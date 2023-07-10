package com.duguanjun;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.sun.org.apache.bcel.internal.generic.ILOAD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerA02Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerA02Application.class, args);
    }

    /**
     * 当前的restTemplate已经变了
     * 如果有@LoadBalanced注解  就会被ribbon所操作
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 往容器中放一个rule对象
     * 你访问任何一个提供者都是这个算法
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
