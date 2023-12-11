package com.example.movie_rental_system.actor;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class ActorMapper {

    public abstract ActorDto toDto(Actor actor);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Actor toEntity(ActorDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Actor actor, ActorDto dto);
}
