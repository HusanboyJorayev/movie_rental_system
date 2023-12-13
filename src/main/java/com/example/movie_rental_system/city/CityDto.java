package com.example.movie_rental_system.city;

import com.example.movie_rental_system.address.Address;
import com.example.movie_rental_system.address.AddressDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Integer id;
    private Integer countryId;
    private String city;

    private List<AddressDto> address;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

