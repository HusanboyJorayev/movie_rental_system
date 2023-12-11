package com.example.movie_rental_system.film_category;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryDto {
    private Integer id;
    private Integer filmId;
    private Integer categoryId;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

