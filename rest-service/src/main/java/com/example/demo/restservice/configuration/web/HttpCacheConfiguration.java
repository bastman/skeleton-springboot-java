package com.example.demo.restservice.configuration.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
@Configuration
public class HttpCacheConfiguration {

    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter(){
        return new ShallowEtagHeaderFilter();
    }
}
