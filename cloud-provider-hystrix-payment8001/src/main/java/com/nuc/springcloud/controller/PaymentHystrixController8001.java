package com.nuc.springcloud.controller;

import com.nuc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentHystrixController8001 {

    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/hystrix/getId/ok/{id}")
    public String getInfoId_OK(@PathVariable("id") Long id){
        String info_ok = paymentService.getInfo_OK(id);
        return info_ok;
    }

    @GetMapping("/payment/hystrix/getId/timeout/{id}")
    public String getInfoId_TimeOut(@PathVariable("id") Long id) throws InterruptedException {
        String info_timeout = paymentService.getInfo_Timeout(id);
        return info_timeout;
    }

}
