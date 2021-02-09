package com.nuc.springcloud.controller;


import com.nuc.config.MyRule;
import com.nuc.springcloud.entiy.CommonResult;
import com.nuc.springcloud.entiy.Payment;
import com.nuc.springcloud.lb.MyBL;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController
{
   public static final String PAYMENT_URL="http://cloud-payment-service";


   @Autowired
   private RestTemplate restTemplate;
   @Autowired
   private DiscoveryClient discoveryClient;
   @Autowired
   private MyBL myBL;

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

   @GetMapping("/consumer/payment/get2/{id}")
   public CommonResult<Payment> get2(@PathVariable("id") Long id){
      log.info("consumer中查询payment，id为="+id);
      ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
      if (entity.getStatusCode().is2xxSuccessful()){
         log.info("查询成功！！！！");
         return new CommonResult<>(entity.getStatusCodeValue(),"查询成功");
      }else {
         log.info("查询失败！！！！");
         return new CommonResult<>(entity.getStatusCodeValue(),"查询失败");
      }
   }

   
   @GetMapping("/consumer/getlb")
   public String getServerPort(){
   List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
   if (instances!=null && instances.size()!=0){
      ServiceInstance serviceInstane = myBL.getServiceInstane(instances);
      URI uri = serviceInstane.getUri();
      System.out.println("轮训获得的服务uri"+uri);
      String serPort = restTemplate.getForObject(uri + "/payment/bl", String.class);
      return serPort;

   }
   return "";
  }
}
