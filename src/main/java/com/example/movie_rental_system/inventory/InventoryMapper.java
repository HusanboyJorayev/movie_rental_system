package com.example.movie_rental_system.inventory;

import com.example.movie_rental_system.rental.RentalMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class InventoryMapper {

    @Autowired
    protected RentalMapper rentalMapper;

    @Mapping(ignore = true, target = "rental")
    public abstract InventoryDto toDto(Inventory inventory);

    @Mapping(target = "rental",expression = "java(inventory.getRental().stream().map(this.rentalMapper::toDto).toList())")
    public abstract InventoryDto toDtoWithOthers(Inventory inventory);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "rental")
    public abstract Inventory toEntity(InventoryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Inventory inventory, InventoryDto dto);

    public void view(Inventory inventory, InventoryDto dto){
        dto.setRental(inventory.getRental().stream().map(this.rentalMapper::toDto).toList());
    }
}
