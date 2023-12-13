package com.example.movie_rental_system.address;

import com.example.movie_rental_system.customer.Customer;
import com.example.movie_rental_system.customer.CustomerDto;
import com.example.movie_rental_system.staff.Staff;
import com.example.movie_rental_system.staff.StaffDto;
import com.example.movie_rental_system.store.Store;
import com.example.movie_rental_system.store.StoreDto;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer id;
    private Integer cityId;
    private String address1;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;

    private List<StaffDto> staff;
    private List<StoreDto>store;
    private List<CustomerDto>customer;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

