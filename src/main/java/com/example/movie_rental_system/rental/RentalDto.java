package com.example.movie_rental_system.rental;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {
    private Integer id;
    private Integer customerId;
    private Integer stuffId;
    private Integer inventoryId;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

