package com.cx.springcloud.controller;

import com.cx.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: ChenXi
 * @time: 2021/1/8 15:22
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id){
        return  paymentHystrixService.payment_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand*//*(fallbackMethod = "paymentTimeOutMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    String payment_timeout(@PathVariable("id") Integer id){
        return  paymentHystrixService.payment_timeout(id);
    }
    public String paymentTimeOutMethod(@PathVariable("id") Integer id){
        return "系统繁忙,请稍后再试";
    }

    //全局统一的降级处理方法
    public String payment_global_FallbackMethod(){
        return "Global异常处理信息,请稍后再试";
    }
}
