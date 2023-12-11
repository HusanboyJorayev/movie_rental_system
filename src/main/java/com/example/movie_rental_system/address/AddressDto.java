package com.example.movie_rental_system.address;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer id;
    private Integer cityId;
    private String address1;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

