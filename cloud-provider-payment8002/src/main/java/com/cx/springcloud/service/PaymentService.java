package com.cx.springcloud.service;


import com.cx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>cloud2020</h3>
 * <p>服务层接口</p>
 *
 * @author : chenxi
 * @date : 2020-12-28 15:33
 **/
public interface PaymentService {
    /**
     *
     * @param payment
     * @return
     */

    public int create(Payment payment);

    /**
     *
     * @param id
     * @return payment对象
     */

    public Payment getPaymentById(@Param("id") Long id);
}
