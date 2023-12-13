package com.example.movie_rental_system.actor;

import com.example.movie_rental_system.film_actor.FilmActorMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class ActorMapper {

    @Autowired
    protected FilmActorMapper filmActorMapper;

    @Mapping(ignore = true,target = "filmActor")
    public abstract ActorDto toDto(Actor actor);


    @Mapping(target = "filmActor",expression = "java(actor.getFilmActor().stream().map(this.filmActorMapper::toDto).toList())")
    public abstract ActorDto toDtoWithOthers(Actor actor);


    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true,target = "filmActor")
    public abstract Actor toEntity(ActorDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Actor actor, ActorDto dto);

    public  void view(Actor actor,ActorDto dto){
        dto.setFilmActor(actor.getFilmActor().stream().map(this.filmActorMapper::toDto).toList());
    }
}
