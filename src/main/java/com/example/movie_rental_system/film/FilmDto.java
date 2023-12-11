package com.example.movie_rental_system.film;

import lombok.*;

import java.time.LocalDateTime;

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


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

