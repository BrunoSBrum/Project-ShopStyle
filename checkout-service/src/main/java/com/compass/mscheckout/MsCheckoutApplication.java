package com.compass.mscheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCheckoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCheckoutApplication.class, args);
    }

}
