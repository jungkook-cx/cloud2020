package com.cx.springcloud.controller;

import com.cx.springcloud.entities.CommonResult;
import com.cx.springcloud.entities.Payment;
import com.cx.springcloud.service.PaymentFeignService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ChenXi
 * @time: 2021/1/8 9:17
 */
@RestController
@Slf4j
@AllArgsConstructor
public class OrderFeignController {
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

}
