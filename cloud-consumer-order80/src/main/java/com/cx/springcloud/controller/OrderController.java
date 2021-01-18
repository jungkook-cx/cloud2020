package com.cx.springcloud.controller;


import com.cx.springcloud.entities.CommonResult;
import com.cx.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <h3>cloud2020</h3>
 * <p>主启动类</p>
 *
 * @author : chenxi
 * @date : 2020-12-28 17:15
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    //private static final String Payment_url="http://localhost:8001";
    private static final String Payment_url="http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(Payment_url+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(Payment_url+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(Payment_url + "/payment/zipkin/", String.class);
        return result;
    }
}
 
