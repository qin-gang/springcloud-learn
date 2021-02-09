package com.nuc.springcloud;

import com.nuc.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-service",configuration=MyRule.class)
public class ConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class,args);
    }
}
