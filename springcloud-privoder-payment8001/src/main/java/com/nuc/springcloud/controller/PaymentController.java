package com.nuc.springcloud.controller;

import com.nuc.springcloud.entiy.CommonResult;
import com.nuc.springcloud.entiy.Payment;
import com.nuc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@Controller("/payment")
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    @ResponseBody
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("********插入结果**********"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功，serverPort-->"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",result);
        }
    }

    @GetMapping("/payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info("接受查询id="+id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果**********"+payment);
        if (null !=payment){
            return new CommonResult(200,"查询数据库成功，serverPort-->"+serverPort,payment);
        }else{
            return new CommonResult(444,"获得数据失败，id="+id,payment);
        }
    }

    @GetMapping("/payment/discovery")
    public Object getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***********"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/bl")
    public String getServerPortBL(){
        return serverPort;
    }

}
