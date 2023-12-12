package com.example.movie_rental_system.inventory;

import com.example.movie_rental_system.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    Optional<Inventory>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select i from Inventory as i
            """)
    List<Inventory> getAll();
}
