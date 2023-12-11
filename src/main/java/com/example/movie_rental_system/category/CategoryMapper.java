package com.example.movie_rental_system.category;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public abstract CategoryDto toDto(Category category);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Category toEntity(CategoryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Category category, CategoryDto dto);
}
