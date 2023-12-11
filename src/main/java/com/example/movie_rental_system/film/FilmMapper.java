package com.example.movie_rental_system.film;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class FilmMapper {

    public abstract FilmDto toDto(Film film);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Film toEntity(FilmDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Film film, FilmDto dto);
}
