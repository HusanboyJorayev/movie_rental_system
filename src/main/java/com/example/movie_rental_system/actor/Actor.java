package com.example.movie_rental_system.actor;

import com.example.movie_rental_system.film_actor.FilmActor;
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
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "actorId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<FilmActor>filmActor;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
