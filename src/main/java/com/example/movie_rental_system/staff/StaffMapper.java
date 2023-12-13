package com.example.movie_rental_system.staff;

import com.example.movie_rental_system.payment.PaymentMapper;
import com.example.movie_rental_system.rental.Rental;
import com.example.movie_rental_system.rental.RentalDto;
import com.example.movie_rental_system.rental.RentalMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class StaffMapper {

    @Autowired
    protected RentalMapper rentalMapper;

    @Autowired
    protected PaymentMapper paymentMapper;


    @Mapping(ignore = true, target = "rental")
    @Mapping(ignore = true, target = "payment")
    public abstract StaffDto toDto(Staff staff);


    @Mapping(target = "rental",expression = "java(staff.getRental().stream().map(this.rentalMapper::toDto).toList())")
    @Mapping( target = "payment",expression = "java(staff.getPayment().stream().map(this.paymentMapper::toDto).toList())")
    public abstract StaffDto toDtoWithOther(Staff staff);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "rental")
    @Mapping(ignore = true, target = "payment")
    public abstract Staff toEntity(StaffDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Staff staff, StaffDto dto);

    public void view(Staff staff, StaffDto dto){
        dto.setRental(staff.getRental().stream().map(this.rentalMapper::toDto).toList());
        dto.setPayment(staff.getPayment().stream().map(this.paymentMapper::toDto).toList());
    }
}
