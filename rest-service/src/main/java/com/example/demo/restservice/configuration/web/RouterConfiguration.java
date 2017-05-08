package com.example.demo.restservice.configuration.web;

import com.example.demo.restservice.configuration.SwaggerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RouterConfiguration {

    private String API_ROUTE_SWAGGER_UI;

    public RouterConfiguration(SwaggerConfiguration swaggerConfiguration) {
        this.API_ROUTE_SWAGGER_UI = swaggerConfiguration.API_ROUTE_SWAGGER_UI;
    }

    @Bean
    public WebMvcConfigurerAdapter forwardIndexPagesToSwaggerDoc() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                configurer.setUseSuffixPatternMatch(false);
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/")
                        .setViewName("redirect:" + API_ROUTE_SWAGGER_UI);
                registry.addViewController("/index.html")
                        .setViewName("redirect:" + API_ROUTE_SWAGGER_UI);
            }
        };
    }
}
