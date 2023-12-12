package com.example.movie_rental_system.staff;

import com.example.movie_rental_system.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select s from Staff as s
            """)
    List<Staff> getAll();
}
