package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Integer> {
    Optional<Rental>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select r from Rental as r
            """)
    List<Rental> getAll();
}
