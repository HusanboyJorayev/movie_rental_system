package com.example.movie_rental_system.country;

import com.example.movie_rental_system.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    Optional<Country>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select c from Country as c
            """)
    List<Country> getAll();
}
