package com.example.movie_rental_system.customer;

import com.example.movie_rental_system.payment.Payment;
import com.example.movie_rental_system.rental.Rental;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer addressId;
    private Integer addressColumn;
    private String firstname;
    private String lastname;
    private String email;
    private Character active;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rental> rental;

    @OneToMany(mappedBy = "rentalId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Payment> payment;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
