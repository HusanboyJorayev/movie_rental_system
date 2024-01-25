package com.example.movie_rental_system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(tags = {})
@Tag(name = "MovieRentalSystemApplication")
public class MovieRentalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalSystemApplication.class, args);
    }

}
