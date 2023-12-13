package com.example.movie_rental_system.film;

import com.example.movie_rental_system.film_actor.FilmActor;
import com.example.movie_rental_system.inventory.Inventory;
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
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer languageId;
    private String title;
    private String description;
    private String specialFeatures;
    private String fullText;
    private Integer releaseYear;
    private Integer rentalDuration;
    private Integer rentalRate;
    private Integer length;
    private Integer replacementCost;
    private Integer rating;

    @OneToMany(mappedBy = "filmId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Inventory>inventory;

    @OneToMany(mappedBy = "filmId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<FilmActor>filmActor;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
