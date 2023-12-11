package com.example.movie_rental_system.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {
    Optional<Film>findByIdAndDeletedAtIsNull(Integer id);
}
