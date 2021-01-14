package com.cx.springcloud.service.impl;

import com.cx.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ChenXi
 * @time: 2021/1/11 10:25
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "PaymentFallbackService-payment_ok";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "PaymentFallbackService-payment_timeout";
    }
}
