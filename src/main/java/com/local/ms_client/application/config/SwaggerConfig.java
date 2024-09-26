package com.local.ms_client.application.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .displayName("Client Api")
                .group("client-api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .version("1.0")
                .description("Client microservice")
                .title("Client - API")
                .contact(new Contact().name("Jhoan Olivo")
                        .email("noj2304@gmail.com")
                        .url("https://github.com/zurimokato/ms-client")
                )
        );
    }
}
