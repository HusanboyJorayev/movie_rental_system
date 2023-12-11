package com.example.movie_rental_system.film;

import com.example.movie_rental_system.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {
    Optional<Film>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select f from Film as f
            """)
    List<Film> getAll();
}
