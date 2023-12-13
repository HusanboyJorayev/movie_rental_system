package com.example.movie_rental_system.staff;

import com.example.movie_rental_system.payment.Payment;
import com.example.movie_rental_system.payment.PaymentDto;
import com.example.movie_rental_system.rental.Rental;
import com.example.movie_rental_system.rental.RentalDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {
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

    private List<RentalDto> rental;
    private List<PaymentDto>payment;




    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

