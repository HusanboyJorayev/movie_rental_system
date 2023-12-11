package com.example.movie_rental_system.payment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Integer id;
    private Integer rentalId;
    private Integer customerId;
    private Integer stuffId;
    private Integer amount;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

