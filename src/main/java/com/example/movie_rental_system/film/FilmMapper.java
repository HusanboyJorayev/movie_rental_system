package com.example.movie_rental_system.film;

import com.example.movie_rental_system.film_actor.FilmActorMapper;
import com.example.movie_rental_system.inventory.InventoryMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class FilmMapper {

    @Autowired
    protected FilmActorMapper filmActorMapper;
    @Autowired
    protected InventoryMapper inventoryMapper;


    @Mapping(ignore = true, target = "inventory")
    @Mapping(ignore = true, target = "filmActor")
    public abstract FilmDto toDto(Film film);


    @Mapping(target = "inventory", expression = "java(film.getInventory().stream().map(this.inventoryMapper::toDto).toList())")
    @Mapping(target = "filmActor", expression = "java(film.getFilmActor().stream().map(this.filmActorMapper::toDto).toList())")
    public abstract FilmDto toDtoWithOthers(Film film);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "inventory")
    @Mapping(ignore = true, target = "filmActor")
    public abstract Film toEntity(FilmDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Film film, FilmDto dto);

    public void view(Film film, FilmDto dto) {
        dto.setFilmActor(film.getFilmActor().stream().map(this.filmActorMapper::toDto).toList());
        dto.setInventory(film.getInventory().stream().map(this.inventoryMapper::toDto).toList());
    }
}
