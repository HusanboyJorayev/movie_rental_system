package com.example.movie_rental_system.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    Optional<Country>findByIdAndDeletedAtIsNull(Integer id);
}
