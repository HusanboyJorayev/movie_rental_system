package com.example.movie_rental_system.city;

import com.example.movie_rental_system.address.Address;
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
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer countryId;
    private String city;

    @OneToMany(mappedBy = "cityId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Address>address;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
