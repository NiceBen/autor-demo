package com.ofben.autordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.ofben.autordemo.response"})
public class AutorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutorDemoApplication.class, args);
    }

}
