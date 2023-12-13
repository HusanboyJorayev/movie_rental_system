package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.payment.Payment;
import com.example.movie_rental_system.payment.PaymentDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {
    private Integer id;
    private Integer customerId;
    private Integer stuffId;
    private Integer inventoryId;

    List<PaymentDto> payment;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

