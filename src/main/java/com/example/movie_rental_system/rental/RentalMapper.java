package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.payment.Payment;
import com.example.movie_rental_system.payment.PaymentDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class RentalMapper {

    public abstract RentalDto toDto(Rental rental);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Rental toEntity(RentalDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Rental rental, RentalDto dto);
}
