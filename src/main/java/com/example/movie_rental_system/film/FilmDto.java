package com.example.movie_rental_system.film;

import com.example.movie_rental_system.film_actor.FilmActor;
import com.example.movie_rental_system.film_actor.FilmActorDto;
import com.example.movie_rental_system.inventory.Inventory;
import com.example.movie_rental_system.inventory.InventoryDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private Integer id;
    private Integer languageId;
    private String title;
    private String description;
    private String specialFeatures;
    private String fullText;
    private Integer releaseYear;
    private Integer rentalDuration;
    private Integer rentalRate;
    private Integer length;
    private Integer replacementCost;
    private Integer rating;

    private List<InventoryDto> inventory;
    private List<FilmActorDto>filmActor;




    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

