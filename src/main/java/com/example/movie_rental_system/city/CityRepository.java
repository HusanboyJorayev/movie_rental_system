package com.example.movie_rental_system.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    Optional<City>findByIdAndDeletedAtIsNull(Integer id);
}
