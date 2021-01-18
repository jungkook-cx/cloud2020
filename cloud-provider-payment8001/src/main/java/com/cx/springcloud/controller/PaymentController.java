package com.cx.springcloud.controller;


import com.cx.springcloud.entities.CommonResult;
import com.cx.springcloud.entities.Payment;
import com.cx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <h3>cloud2020</h3>
 * <p>controller层</p>
 *
 * @author : chenxi
 * @date : 2020-12-28 15:46
 **/
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int resut=paymentService.create(payment);
        if (resut>0){
            return new CommonResult(200,"插入成功,serverPort"+serverPort,resut);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        Payment payment = paymentService.getPaymentById(id);
        if (!Objects.isNull(payment)){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录"+id,null);

        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin(){
        return "hi,I'am paymentZipKin server fall back";
    }

}
 
