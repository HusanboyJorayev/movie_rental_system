package com.example.movie_rental_system.address;

import com.example.movie_rental_system.customer.Customer;
import com.example.movie_rental_system.staff.Staff;
import com.example.movie_rental_system.store.Store;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cityId;
    private String address1;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;

    @OneToMany(mappedBy = "addressId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Staff>staff;

    @OneToMany(mappedBy = "addressId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Store>store;

    @OneToMany(mappedBy = "addressId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Customer>customer;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
