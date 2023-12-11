package com.example.movie_rental_system.city;

import com.example.movie_rental_system.category.Category;
import com.example.movie_rental_system.category.CategoryDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class CityMapper {

    public abstract CityDto toDto(City city);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract City toEntity(CityDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget City city, CityDto dto);
}
