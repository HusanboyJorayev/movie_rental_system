package com.example.movie_rental_system.country;

import com.example.movie_rental_system.city.City;
import com.example.movie_rental_system.city.CityDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class CountryMapper {
    public abstract CountryDto toDto(Country country);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Country toEntity(CountryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Country country, CountryDto dto);
}
