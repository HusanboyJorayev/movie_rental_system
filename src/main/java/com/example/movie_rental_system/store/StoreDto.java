package com.example.movie_rental_system.store;

import com.example.movie_rental_system.staff.Staff;
import com.example.movie_rental_system.staff.StaffDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
    private Integer id;
    private Integer addressId;

    private List<StaffDto> staff;




    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

