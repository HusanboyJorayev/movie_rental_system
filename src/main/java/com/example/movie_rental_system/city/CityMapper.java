package com.example.movie_rental_system.city;

import com.example.movie_rental_system.address.AddressMapper;
import com.example.movie_rental_system.category.Category;
import com.example.movie_rental_system.category.CategoryDto;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class CityMapper {

    @Autowired
    protected AddressMapper addressMapper;

    @Mapping(ignore = true, target = "address")
    public abstract CityDto toDto(City city);


    @Mapping(target = "address",expression = "java(city.getAddress().stream().map(this.addressMapper::toDto).toList())")
    public abstract CityDto toDtoWithOthers(City city);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "address")
    public abstract City toEntity(CityDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget City city, CityDto dto);

    public void view(City city,CityDto dto){
        dto.setAddress(city.getAddress().stream().map(this.addressMapper::toDto).toList());
    }
}
