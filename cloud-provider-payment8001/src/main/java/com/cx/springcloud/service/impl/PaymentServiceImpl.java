package com.cx.springcloud.service.impl;

import com.cx.springcloud.dao.PaymentDao;
import com.cx.springcloud.service.PaymentService;
import com.cx.springcloud.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h3>cloud2020</h3>
 * <p>实现类</p>
 *
 * @author : chenxi
 * @date : 2020-12-28 15:36
 **/
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {


    private  PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {

        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
 
