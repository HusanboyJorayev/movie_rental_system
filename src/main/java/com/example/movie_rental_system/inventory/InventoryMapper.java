package com.example.movie_rental_system.inventory;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class InventoryMapper {

    public abstract InventoryDto toDto(Inventory inventory);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Inventory toEntity(InventoryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Inventory inventory, InventoryDto dto);
}
