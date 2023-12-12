package com.example.movie_rental_system.payment;

import com.example.movie_rental_system.language.Language;
import com.example.movie_rental_system.language.LanguageDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper {

    public abstract PaymentDto toDto(Payment payment);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Payment toEntity(PaymentDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Payment payment, PaymentDto dto);
}
