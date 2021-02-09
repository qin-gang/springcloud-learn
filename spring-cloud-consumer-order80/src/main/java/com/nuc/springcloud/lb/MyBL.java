package com.nuc.springcloud.lb;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyBL implements LB {

    private AtomicInteger nextServerCyclicCounter= new AtomicInteger(0);

    private final int getNext(){
        int current;
        int next;
        do {
            current=this.nextServerCyclicCounter.get();
            next= (current+1 > Integer.MAX_VALUE ? 0:(current+1));
        }while (!this.nextServerCyclicCounter.compareAndSet(current,next));
        System.out.println("current---->"+current);
        System.out.println("第"+next+"调用---负载均衡,将要更新的值");
        return next;
    }

    @Override
    public ServiceInstance getServiceInstane(List<ServiceInstance> reachableServers) {
        if (reachableServers.size()!=0 && reachableServers!=null){
            int index= getNext() % reachableServers.size();
            return reachableServers.get(index);
        }else {
            return null;
        }
    }

}
