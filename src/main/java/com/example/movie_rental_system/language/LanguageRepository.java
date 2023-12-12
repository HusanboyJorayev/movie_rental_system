package com.example.movie_rental_system.language;

import com.example.movie_rental_system.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select l from Language as l
            """)
    List<Language> getAll();
}
