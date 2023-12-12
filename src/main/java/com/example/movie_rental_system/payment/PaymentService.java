package com.example.movie_rental_system.payment;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.language.Language;
import com.example.movie_rental_system.language.LanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService implements SimpleCrud<Integer, PaymentDto> {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public ResponseDto<PaymentDto> create(PaymentDto dto) {
        Payment payment = this.paymentMapper.toEntity(dto);
        payment.setCreatedAt(LocalDateTime.now());
        this.paymentRepository.save(payment);

        return ResponseDto.<PaymentDto>builder()
                .success(true)
                .message("Ok")
                .data(this.paymentMapper.toDto(payment))
                .build();
    }

    @Override
    public ResponseDto<PaymentDto> get(Integer id) {
        return this.paymentRepository.findByIdAndDeletedAtIsNull(id)
                .map(payment -> ResponseDto.<PaymentDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.paymentMapper.toDto(payment))
                        .build())
                .orElse(ResponseDto.<PaymentDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<PaymentDto> update(PaymentDto dto, Integer id) {
        return this.paymentRepository.findByIdAndDeletedAtIsNull(id)
                .map(payment -> {
                    payment.setUpdatedAt(LocalDateTime.now());
                    this.paymentMapper.update(payment, dto);
                    this.paymentRepository.save(payment);
                    return ResponseDto.<PaymentDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.paymentMapper.toDto(payment))
                            .build();
                })
                .orElse(ResponseDto.<PaymentDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<PaymentDto> delete(Integer id) {
        return this.paymentRepository.findByIdAndDeletedAtIsNull(id)
                .map(payment -> {
                    payment.setDeletedAt(LocalDateTime.now());
                    this.paymentRepository.delete(payment);
                    return ResponseDto.<PaymentDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.paymentMapper.toDto(payment))
                            .build();
                })
                .orElse(ResponseDto.<PaymentDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<PaymentDto>> getAll() {
        List<Payment> list = this.paymentRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<PaymentDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<PaymentDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.paymentMapper::toDto).toList())
                .build();
    }
}
