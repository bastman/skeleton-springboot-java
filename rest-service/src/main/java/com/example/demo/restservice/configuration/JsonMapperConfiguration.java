package com.example.demo.restservice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonMapperConfiguration {

    @Bean
    public ObjectMapper objectMapper(){
        return defaultMapper();
    }

    public static ObjectMapper defaultMapper() {
        return new ObjectMapper()
                .registerModules(
                        new JavaTimeModule(),
                        new Jdk8Module(),
                        new ParameterNamesModule()
                ).disable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS,
                        SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS
                );
    }
}
