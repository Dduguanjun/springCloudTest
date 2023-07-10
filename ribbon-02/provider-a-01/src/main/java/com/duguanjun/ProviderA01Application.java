package com.duguanjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderA01Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderA01Application.class, args);
    }

}
