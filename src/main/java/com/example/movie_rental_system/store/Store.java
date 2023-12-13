package com.example.movie_rental_system.store;

import com.example.movie_rental_system.address.Address;
import com.example.movie_rental_system.staff.Staff;
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
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer addressId;

    @OneToMany(mappedBy = "storeId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Staff>staff;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
