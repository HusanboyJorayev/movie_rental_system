package com.example.movie_rental_system.actor;

import com.example.movie_rental_system.film_actor.FilmActor;
import com.example.movie_rental_system.film_actor.FilmActorDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDto {
    private Integer id;
    private String firstname;
    private String lastname;

    private List<FilmActorDto> filmActor;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
