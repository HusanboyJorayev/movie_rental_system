package com.example.movie_rental_system.address;

import com.example.movie_rental_system.actor.Actor;
import com.example.movie_rental_system.actor.ActorDto;
import com.example.movie_rental_system.customer.CustomerMapper;
import com.example.movie_rental_system.staff.StaffMapper;
import com.example.movie_rental_system.store.StoreMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class AddressMapper {
    @Autowired
    protected StoreMapper storeMapper;
    @Autowired
    protected StaffMapper staffMapper;
    @Autowired
    protected CustomerMapper customerMapper;


    @Mapping(ignore = true, target = "staff")
    @Mapping(ignore = true, target = "store")
    @Mapping(ignore = true, target = "customer")
    public abstract AddressDto toDto(Address address);



    @Mapping(target = "staff",expression = "java(address.getStaff().stream().map(this.staffMapper::toDto).toList())")
    @Mapping(target = "store",expression = "java(address.getStore().stream().map(this.storeMapper::toDto).toList())")
    @Mapping(target = "customer",expression = "java(address.getCustomer().stream().map(this.customerMapper::toDto).toList())")
    public abstract AddressDto toDtoWithOthers(Address address);


    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "staff")
    @Mapping(ignore = true, target = "store")
    @Mapping(ignore = true, target = "customer")
    public abstract Address toEntity(AddressDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Address address, AddressDto dto);


    public void view(Address address,AddressDto dto){
        dto.setStaff(address.getStaff().stream().map(this.staffMapper::toDto).toList());
        dto.setStore(address.getStore().stream().map(this.storeMapper::toDto).toList());
        dto.setCustomer(address.getCustomer().stream().map(this.customerMapper::toDto).toList());
    }
}
