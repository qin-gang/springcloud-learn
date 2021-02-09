package com.nuc.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class PaymentService {

    //hystrix中正常的情况
    public String getInfo_OK(Long id) {
        return Thread.currentThread().getName() + "id---->" + id + "哈哈~~~~~~";
    }

    //hystrix中超时的情况
    @HystrixCommand(fallbackMethod = "getInfo_Timeout_handler")
    public String getInfo_Timeout(Long id) throws InterruptedException {
        log.info("getInfo_Timeout");
        int timeNumber = 5000;
        int i=10/0;

        //TimeUnit.MILLISECONDS.sleep(timeNumber);

        return "线程"+Thread.currentThread().getName() + "id---->" + id + "超时中~~~~~~";
    }

    public String getInfo_Timeout_handler(Long id) {
        log.info("getInfo_Timeout_handler()----------------- ");
        return "线程"+Thread.currentThread().getName()+"系统超时，请稍后再来";
    }
}
