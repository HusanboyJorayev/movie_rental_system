package com.example.movie_rental_system.country;

import com.example.movie_rental_system.city.City;
import com.example.movie_rental_system.city.CityDto;
import com.example.movie_rental_system.city.CityMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class CountryMapper {

    @Autowired
    protected CityMapper cityMapper;

    @Mapping(ignore = true, target = "city")
    public abstract CountryDto toDto(Country country);


    @Mapping(target = "city", expression = "java(country.getCity().stream().map(this.cityMapper::toDto).toList())")
    public abstract CountryDto toDtoWithOthers(Country country);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "city")
    public abstract Country toEntity(CountryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Country country, CountryDto dto);

    public void view(Country country, CountryDto dto) {
        dto.setCity(country.getCity().stream().map(this.cityMapper::toDto).toList());
    }
}
