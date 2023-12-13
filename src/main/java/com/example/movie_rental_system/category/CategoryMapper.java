package com.example.movie_rental_system.category;

import com.example.movie_rental_system.film_category.FilmCategoryMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class CategoryMapper {
    @Autowired
    protected FilmCategoryMapper filmCategoryMapper;

    @Mapping(ignore = true, target = "filmCategory")
    public abstract CategoryDto toDto(Category category);

    @Mapping(target = "filmCategory", expression = "java(category.getFilmCategory().stream().map(this.filmCategoryMapper::toDto).toList())")
    public abstract CategoryDto toDtoWithOthers(Category category);


    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "filmCategory")
    public abstract Category toEntity(CategoryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Category category, CategoryDto dto);

    public void view(Category category, CategoryDto dto) {
        dto.setFilmCategory(category.getFilmCategory().stream().map(this.filmCategoryMapper::toDto).toList());
    }
}
