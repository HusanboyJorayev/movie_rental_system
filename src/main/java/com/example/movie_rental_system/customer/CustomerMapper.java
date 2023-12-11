package com.example.movie_rental_system.customer;

import com.example.movie_rental_system.country.Country;
import com.example.movie_rental_system.country.CountryDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public abstract CustomerDto toDto(Customer customer);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Customer toEntity(CustomerDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Customer customer, CustomerDto dto);
}
