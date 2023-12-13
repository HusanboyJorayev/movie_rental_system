package com.example.movie_rental_system.category;

import com.example.movie_rental_system.film_category.FilmCategory;
import com.example.movie_rental_system.film_category.FilmCategoryDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;

    private List<FilmCategoryDto> filmCategory;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

