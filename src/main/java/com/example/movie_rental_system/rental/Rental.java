package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.payment.Payment;
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
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private Integer stuffId;
    private Integer inventoryId;

    @OneToMany(mappedBy = "",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Payment>payment;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
