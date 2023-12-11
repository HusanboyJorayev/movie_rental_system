package com.example.movie_rental_system.film_actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor,Integer> {
    Optional<FilmActor>findByIdAndDeletedAtIsNull(Integer id);
}
