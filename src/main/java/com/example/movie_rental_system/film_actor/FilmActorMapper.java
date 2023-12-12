package com.example.movie_rental_system.film_actor;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class FilmActorMapper {

    public abstract FilmActorDto toDto(FilmActor filmActor);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract FilmActor toEntity(FilmActorDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget FilmActor filmActor, FilmActorDto dto);
}
