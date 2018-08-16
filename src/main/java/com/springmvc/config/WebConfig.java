package com.springmvc.config;

import com.springmvc.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    GlobalExceptionHandler getglobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
