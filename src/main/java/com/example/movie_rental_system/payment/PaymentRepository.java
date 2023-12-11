package com.example.movie_rental_system.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Optional<Payment>findByIdAndDeletedAtIsNull(Integer id);
}
