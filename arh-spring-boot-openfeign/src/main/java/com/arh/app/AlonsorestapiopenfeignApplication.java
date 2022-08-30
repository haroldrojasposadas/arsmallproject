package com.arh.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlonsorestapiopenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlonsorestapiopenfeignApplication.class, args);
	}

}
