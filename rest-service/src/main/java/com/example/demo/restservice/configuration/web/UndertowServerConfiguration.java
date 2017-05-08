package com.example.demo.restservice.configuration.web;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UndertowServerConfiguration {
    @Bean
    public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(
                (Undertow.Builder builder) -> {
                    builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true);
                }
        );

        return factory;
    }

}
