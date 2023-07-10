package com.duguanjun;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientAApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientAApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("222222222");
		System.out.println("master test");
		System.out.println("hot-fix!");

	}
}
