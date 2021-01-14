package com.cx.springcloud.dao;


import com.cx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xi.chen
 */
@Mapper
public interface PaymentDao {
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
