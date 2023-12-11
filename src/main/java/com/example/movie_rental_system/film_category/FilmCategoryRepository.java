package com.example.movie_rental_system.film_category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory,Integer> {
    Optional<FilmCategory>findByIdAndDeletedAtIsNull(Integer id);
}
