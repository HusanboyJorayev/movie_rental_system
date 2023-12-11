package com.example.movie_rental_system.city;

import com.example.movie_rental_system.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    Optional<City>findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select c from City as c
            """)
    List<City> getAll();
}
