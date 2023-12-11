package com.example.movie_rental_system.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    Optional<Staff>findByIdAndDeletedAtIsNull(Integer id);
}
