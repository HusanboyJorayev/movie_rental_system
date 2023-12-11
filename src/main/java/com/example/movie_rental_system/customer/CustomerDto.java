package com.example.movie_rental_system.customer;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Integer id;
    private Integer addressId;
    private Integer addressColumn;
    private String firstname;
    private String lastname;
    private String email;
    private Character active;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

