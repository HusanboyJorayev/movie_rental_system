package com.example.movie_rental_system.store;

import com.example.movie_rental_system.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
    Optional<Store>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select s from Store as s
            """)
    List<Store> getAll();
}
