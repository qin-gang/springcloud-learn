package com.nuc.springcloud.controller;

import com.nuc.springcloud.entiy.CommonResult;
import com.nuc.springcloud.entiy.Payment;
import com.nuc.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/fegin/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> commonResult = paymentFeignService.getPaymentById(id);
        return commonResult;
    }
}
