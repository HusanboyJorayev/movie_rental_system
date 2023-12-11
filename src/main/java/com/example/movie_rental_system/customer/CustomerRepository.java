package com.example.movie_rental_system.customer;

import com.example.movie_rental_system.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select c from Customer as c
            """)
    List<Customer> getAll();
}
