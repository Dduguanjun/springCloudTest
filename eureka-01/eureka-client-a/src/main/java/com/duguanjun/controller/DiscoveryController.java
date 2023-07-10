package com.duguanjun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/test")
    public String doDiscovery(String serviceName){
        //这里去b中找对应的端口和ip

        //服务发现
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        instances.forEach(System.out::println);

        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();

        System.out.println("host:" + host + " port:" + port);
        return instances.get(0).toString();
    }
}
