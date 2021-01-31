package com.nuc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerOrder80.class,args);
    }
}
