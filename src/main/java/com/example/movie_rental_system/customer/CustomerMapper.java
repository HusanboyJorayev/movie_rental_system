package com.example.movie_rental_system.customer;

import com.example.movie_rental_system.country.Country;
import com.example.movie_rental_system.country.CountryDto;
import com.example.movie_rental_system.payment.PaymentMapper;
import com.example.movie_rental_system.rental.RentalMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class CustomerMapper {


    @Autowired
    protected RentalMapper rentalMapper;
    @Autowired
    protected PaymentMapper paymentMapper;


    @Mapping(ignore = true, target = "rental")
    @Mapping(ignore = true, target = "payment")
    public abstract CustomerDto toDto(Customer customer);


    @Mapping(target = "rental", expression = "java(customer.getRental().stream().map(this.rentalMapper::toDto).toList())")
    @Mapping(target = "payment", expression = "java(customer.getPayment().stream().map(this.paymentMapper::toDto).toList())")
    public abstract CustomerDto toDtoWithOthers(Customer customer);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "rental")
    @Mapping(ignore = true, target = "payment")
    public abstract Customer toEntity(CustomerDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Customer customer, CustomerDto dto);

    public void view(Customer customer, CustomerDto dto) {
        dto.setRental(customer.getRental().stream().map(this.rentalMapper::toDto).toList());
        dto.setPayment(customer.getPayment().stream().map(this.paymentMapper::toDto).toList());
    }
}
