package com.example.movie_rental_system.store;

import com.example.movie_rental_system.staff.Staff;
import com.example.movie_rental_system.staff.StaffDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class StoreMapper {

    public abstract StoreDto toDto(Store store);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Store toEntity(StoreDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Store store, StoreDto dto);
}
