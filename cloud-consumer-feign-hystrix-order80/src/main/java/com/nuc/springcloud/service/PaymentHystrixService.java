package com.nuc.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/getId/ok/{id}")
    public String getIdOk(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/getId/timeout/{id}")
    public String getInfo_Timeout(@PathVariable("id") Long id);

}
