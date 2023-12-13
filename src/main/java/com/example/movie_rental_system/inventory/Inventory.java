package com.example.movie_rental_system.inventory;

import com.example.movie_rental_system.rental.Rental;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer filmId;

    @OneToMany(mappedBy = "inventoryId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Rental>rental;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
