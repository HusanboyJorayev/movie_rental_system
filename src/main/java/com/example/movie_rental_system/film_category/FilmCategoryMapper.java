package com.example.movie_rental_system.film_category;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class FilmCategoryMapper {

    public abstract FilmCategoryDto toDto(FilmCategory filmCategory);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract FilmCategory toEntity(FilmCategoryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget FilmCategory filmCategory, FilmCategoryDto dto);
}
