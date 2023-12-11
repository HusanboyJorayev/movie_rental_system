package com.example.movie_rental_system.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select a from Address as a
            """)
    List<Address> getAll();
}
