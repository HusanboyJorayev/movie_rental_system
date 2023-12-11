package com.example.movie_rental_system.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Optional<Actor> findByIdAndDeletedAtIsNull(Integer id);

   // List<Actor> findAllByDeletedAtIsNull();

    @Query("""
            select a from Actor as a
            """)
    List<Actor> getAll();
}
