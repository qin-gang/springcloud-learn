package com.nuc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {
    private String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getServerPort")
    public String getServerPort(){
        log.info("zk的消費者---->getServerPort");
        return restTemplate.getForObject(INVOKE_URL+"/payment/serverPort",String.class);
    }


}
