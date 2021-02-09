package com.nuc.springcloud.controller;

import com.nuc.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/getId/ok/{id}")
    public String getIdOk(@PathVariable("id") Long id){
        return paymentHystrixService.getIdOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/getId/timeout/{id}")
    public String getIdTimeOut(@PathVariable("id") Long id){
        return paymentHystrixService.getInfo_Timeout(id);
    }

}
