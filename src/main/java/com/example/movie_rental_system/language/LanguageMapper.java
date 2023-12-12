package com.example.movie_rental_system.language;

import com.example.movie_rental_system.inventory.Inventory;
import com.example.movie_rental_system.inventory.InventoryDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class LanguageMapper {

    public abstract LanguageDto toDto(Language language);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Language toEntity(LanguageDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Language language, LanguageDto dto);
}
