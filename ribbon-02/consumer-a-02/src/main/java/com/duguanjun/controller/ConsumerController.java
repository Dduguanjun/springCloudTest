package com.duguanjun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     *思考：ribbon是怎么样将http://ribbon-provider/hello 路径请求成功
     * http://localhost:8011/hello
     * 1.拦截这个请求
     * 2.截取主机名称
     * 3.借助eureka进行服务发现操作  List<ServiceInstance> lists = discoveryClient.getInstances(serviceName);
     * 4.通过负载均衡拿到一个ip 和 port
     * 5.reConstructUrl
     * 6.发起请求
     * @param serviceName
     * @return
     */
    @GetMapping("/testRibbon")
    public String testRibbon(String serviceName){

        String url = "http://" + serviceName + "/hello";
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }

    @GetMapping("/testRibbonRule")
    public String testRibbonRule(String serviceName){

        ServiceInstance choose = loadBalancerClient.choose(serviceName);

        return choose.toString();
    }
}
