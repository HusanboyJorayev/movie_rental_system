package com.example.movie_rental_system.store;

import com.example.movie_rental_system.staff.Staff;
import com.example.movie_rental_system.staff.StaffDto;
import com.example.movie_rental_system.staff.StaffMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class StoreMapper {

    @Autowired
    protected StaffMapper staffMapper;
    @Mapping(ignore = true, target = "staff")
    public abstract StoreDto toDto(Store store);

    @Mapping(target = "staff",expression = "java(store.getStaff().stream().map(this.staffMapper::toDto).toList())")
    public abstract StoreDto toDtoWithOther(Store store);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(ignore = true, target = "staff")
    public abstract Store toEntity(StoreDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Store store, StoreDto dto);

    public void view(Store store, StoreDto dto){
        dto.setStaff(store.getStaff().stream().map(this.staffMapper::toDto).toList());
    }
}
