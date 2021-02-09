package com.nuc.springcloud.service;

import com.nuc.springcloud.entiy.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
