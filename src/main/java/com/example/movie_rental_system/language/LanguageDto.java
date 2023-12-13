package com.example.movie_rental_system.language;

import com.example.movie_rental_system.film.Film;
import com.example.movie_rental_system.film.FilmDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
    private Integer id;
    private String name;

    private List<FilmDto> film;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

