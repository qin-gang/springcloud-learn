package com.nuc.springcloud.conifg;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level getFeignLogger(){
        return Logger.Level.FULL;
    }
}
