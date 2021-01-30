package com.nuc.springcloud.controller;

import com.nuc.springcloud.entiy.CommonResult;
import com.nuc.springcloud.entiy.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController
{
   public static final String PAYMENT_URL="http://cloud-payment-service";

   @Autowired
   private RestTemplate restTemplate;

   @GetMapping("/consumer/payment/create")
   public CommonResult<Payment> create(Payment payment){
      log.info("consumer中create方法,payment.serial="+payment.getSerial());
      return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
   }

   @GetMapping("/consumer/payment/get/{id}")
   public CommonResult<Payment> get(@PathVariable("id") Long id){
      log.info("consumer中查询payment，id为="+id);
      return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
   }
}
