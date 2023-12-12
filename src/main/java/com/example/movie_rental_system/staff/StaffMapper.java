package com.example.movie_rental_system.staff;

import com.example.movie_rental_system.rental.Rental;
import com.example.movie_rental_system.rental.RentalDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {

    public abstract StaffDto toDto(Staff staff);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Staff toEntity(StaffDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Staff staff, StaffDto dto);
}
