package com.example.movie_rental_system.staff;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {
    private Integer id;
    private Integer addressId;
    private Integer paymentId;
    private Integer storeId;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Character active;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

