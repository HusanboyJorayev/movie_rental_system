package com.example.movie_rental_system.address;

import com.example.movie_rental_system.actor.Actor;
import com.example.movie_rental_system.actor.ActorDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public abstract AddressDto toDto(Address address);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Address toEntity(AddressDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Address address, AddressDto dto);
}
