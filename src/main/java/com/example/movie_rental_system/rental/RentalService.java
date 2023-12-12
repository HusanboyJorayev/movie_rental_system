package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.payment.Payment;
import com.example.movie_rental_system.payment.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService implements SimpleCrud<Integer, RentalDto> {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    @Override
    public ResponseDto<RentalDto> create(RentalDto dto) {
        Rental rental = this.rentalMapper.toEntity(dto);
        rental.setCreatedAt(LocalDateTime.now());
        this.rentalRepository.save(rental);

        return ResponseDto.<RentalDto>builder()
                .success(true)
                .message("Ok")
                .data(this.rentalMapper.toDto(rental))
                .build();
    }

    @Override
    public ResponseDto<RentalDto> get(Integer id) {
        return this.rentalRepository.findByIdAndDeletedAtIsNull(id)
                .map(rental -> ResponseDto.<RentalDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.rentalMapper.toDto(rental))
                        .build())
                .orElse(ResponseDto.<RentalDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<RentalDto> update(RentalDto dto, Integer id) {
        return this.rentalRepository.findByIdAndDeletedAtIsNull(id)
                .map(rental -> {
                    rental.setUpdatedAt(LocalDateTime.now());
                    this.rentalMapper.update(rental, dto);
                    this.rentalRepository.save(rental);
                    return ResponseDto.<RentalDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.rentalMapper.toDto(rental))
                            .build();
                })
                .orElse(ResponseDto.<RentalDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<RentalDto> delete(Integer id) {
        return this.rentalRepository.findByIdAndDeletedAtIsNull(id)
                .map(rental -> {
                    rental.setDeletedAt(LocalDateTime.now());
                    this.rentalRepository.delete(rental);
                    return ResponseDto.<RentalDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.rentalMapper.toDto(rental))
                            .build();
                })
                .orElse(ResponseDto.<RentalDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<RentalDto>> getAll() {
        List<Rental> list = this.rentalRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<RentalDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<RentalDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.rentalMapper::toDto).toList())
                .build();
    }
}
