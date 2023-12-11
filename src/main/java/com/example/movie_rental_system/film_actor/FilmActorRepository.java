package com.example.movie_rental_system.film_actor;

import com.example.movie_rental_system.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor,Integer> {
    Optional<FilmActor>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select f from FilmActor as f
            """)
    List<FilmActor> getAll();
}
