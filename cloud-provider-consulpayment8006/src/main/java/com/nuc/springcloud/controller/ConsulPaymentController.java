package com.nuc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul/payment/getServerPort")
    public String getServerPort(){
        log.info("ConSul---8006!!!!!!!");
        return "consul----->ServerPort:"+serverPort+"\t"+UUID.randomUUID().toString();
    }
}
