package com.example.demo.restservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2()
public class SwaggerConfiguration {

    public final String API_ROUTE_SWAGGER_UI = "/swagger-ui.html";

    private final ApiInfo apiInfo;

    public SwaggerConfiguration(
            @Value("${app.appName}") String appName
    ) {
        this.apiInfo=new ApiInfoBuilder()
                .title(appName)
                .description("This is an example microservice application.")
                .build();
    }

    @Bean
    public Docket demoApiDocket(){
        String groupName = "demo-api";
        String basePackage = "com.example.demo.restservice.api";

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .securitySchemes(
                        Collections.singletonList(
                                new BasicAuth("basic-auth-realm")
                        )
                );
    }
}
