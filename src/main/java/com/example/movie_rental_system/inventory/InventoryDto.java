package com.example.movie_rental_system.inventory;

import com.example.movie_rental_system.rental.Rental;
import com.example.movie_rental_system.rental.RentalDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private Integer id;
    private Integer filmId;

    private List<RentalDto> rental;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

