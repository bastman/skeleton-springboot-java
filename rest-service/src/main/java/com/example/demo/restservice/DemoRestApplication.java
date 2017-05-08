package com.example.demo.restservice;


import com.example.demo.logging.AppLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoRestApplication{
    private final Logger LOGGER = AppLogger.get(DemoRestApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(DemoRestApplication.class)
                    .web(true)
                .run(args);
    }

    @Bean
    public CommandLineRunner init(
            ConfigurableApplicationContext ctx,
            @Value("${app.appName}") String appName
    ) {
        return (args)->{
                LOGGER.info("=== init "+appName+" - "+ctx+" =====");
        };
    }
}
