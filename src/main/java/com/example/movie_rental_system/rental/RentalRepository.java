package com.example.movie_rental_system.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Integer> {
    Optional<Rental>findByIdAndDeletedAtIsNull(Integer id);
}
