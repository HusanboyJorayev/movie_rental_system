package com.example.movie_rental_system.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
    Optional<Store>findByIdAndDeletedAtIsNull(Integer id);
}
