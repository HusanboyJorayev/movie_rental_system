package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.payment.Payment;
import com.example.movie_rental_system.payment.PaymentDto;
import com.example.movie_rental_system.payment.PaymentMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class RentalMapper {

    @Autowired
    protected PaymentMapper paymentMapper;

    @Mapping(ignore = true, target = "payment")
    public abstract RentalDto toDto(Rental rental);

    @Mapping(target = "payment",expression = "java(rental.getPayment().stream().map(this.paymentMapper::toDto).toList())")
    public abstract RentalDto toDtoWithOthers(Rental rental);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "payment")
    public abstract Rental toEntity(RentalDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Rental rental, RentalDto dto);


    public void view(Rental rental, RentalDto dto){
        dto.setPayment(rental.getPayment().stream().map(this.paymentMapper::toDto).toList());
    }
}
