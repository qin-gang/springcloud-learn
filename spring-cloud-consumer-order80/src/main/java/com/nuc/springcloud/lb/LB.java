package com.nuc.springcloud.lb;

import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LB {
   ServiceInstance getServiceInstane(List<ServiceInstance> reachableServers);
}
