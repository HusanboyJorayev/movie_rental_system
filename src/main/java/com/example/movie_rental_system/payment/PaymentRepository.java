package com.example.movie_rental_system.payment;

import com.example.movie_rental_system.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Optional<Payment>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select p from Payment as p
            """)
    List<Payment> getAll();
}
