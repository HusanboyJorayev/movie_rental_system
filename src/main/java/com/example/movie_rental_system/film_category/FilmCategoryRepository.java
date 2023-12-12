package com.example.movie_rental_system.film_category;

import com.example.movie_rental_system.film_actor.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory,Integer> {
    Optional<FilmCategory>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select f from FilmCategory as f
            """)
    List<FilmCategory> getAll();
}
