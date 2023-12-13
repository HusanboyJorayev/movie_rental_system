package com.example.movie_rental_system.staff;

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
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer addressId;
    private Integer paymentId;
    private Integer storeId;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Character active;


    @OneToMany(mappedBy = "stuffId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Rental>rental;

    @OneToMany(mappedBy = "stuffId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Payment>payment;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
