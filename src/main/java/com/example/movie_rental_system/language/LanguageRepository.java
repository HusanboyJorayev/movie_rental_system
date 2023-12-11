package com.example.movie_rental_system.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Optional<Language>findByIdAndDeletedAtIsNull(Integer id);
}
