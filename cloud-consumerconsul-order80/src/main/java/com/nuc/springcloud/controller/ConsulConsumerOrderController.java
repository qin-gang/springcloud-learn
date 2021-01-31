package com.nuc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsulConsumerOrderController {

    private String INVOKE_URL="http://provider-consul-payment8006";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul/consumer/order/getServerPort")
    public String getServerPort(){
        log.info("进入ConsulConsumerOrderController！！！！！！");
        return restTemplate.getForObject(INVOKE_URL+"/consul/payment/getServerPort",String.class);
    }
}
