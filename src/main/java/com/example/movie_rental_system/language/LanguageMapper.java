package com.example.movie_rental_system.language;

import com.example.movie_rental_system.film.FilmMapper;
import com.example.movie_rental_system.inventory.Inventory;
import com.example.movie_rental_system.inventory.InventoryDto;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class LanguageMapper {

    @Autowired
    protected FilmMapper filmMapper;

    @Mapping(ignore = true, target = "film")
    public abstract LanguageDto toDto(Language language);

    @Mapping(target = "film",expression = "java(language.getFilm().stream().map(this.filmMapper::toDto).toList())")
    public abstract LanguageDto toDtoWithOther(Language language);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "film")
    public abstract Language toEntity(LanguageDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Language language, LanguageDto dto);


    public void view(Language language, LanguageDto dto){
        dto.setFilm(language.getFilm().stream().map(this.filmMapper::toDto).toList());
    }
}
