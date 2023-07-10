package com.duguanjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderB01Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderB01Application.class, args);
    }

}
