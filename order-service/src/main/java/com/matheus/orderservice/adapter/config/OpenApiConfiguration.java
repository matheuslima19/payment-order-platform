package com.matheus.orderservice.adapter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI orderServiceOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service API")
                        .description("API para criacao e consulta de pedidos.")
                        .version("v1"));
    }
}
