package com.example.movie_rental_system.film_actor;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorDto {
    private Integer id;
    private Integer filmId;
    private Integer actorId;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

