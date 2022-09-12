package com.arh.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.okhttp.OkHttpClient;

@Configuration
public class FeignClientConfiguration {
	
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
	
	@Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

}
