package com.example.movie_rental_system.country;

import com.example.movie_rental_system.city.City;
import com.example.movie_rental_system.city.CityDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private Integer id;
    private String country;

    private List<CityDto> city;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

