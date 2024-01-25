package com.example.movie_rental_system.swaggerApi;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerApi {

    @Bean
    public GroupedOpenApi actorApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/actor/**")
                .group("actor")
                .build();
    }

    @Bean
    public GroupedOpenApi addressApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/address/**")
                .group("address")
                .build();
    }

    @Bean
    public GroupedOpenApi categoryApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/category/**")
                .group("category")
                .build();
    }
    @Bean
    public GroupedOpenApi cityApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/city/**")
                .group("city")
                .build();
    }
}
