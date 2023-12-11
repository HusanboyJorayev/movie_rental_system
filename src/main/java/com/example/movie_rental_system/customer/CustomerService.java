package com.example.movie_rental_system.customer;

import com.example.movie_rental_system.country.Country;
import com.example.movie_rental_system.country.CountryDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements SimpleCrud<Integer, CustomerDto> {
    private final CustomerValidation customerValidation;
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public ResponseDto<CustomerDto> create(CustomerDto dto) {
        Customer customer = this.customerMapper.toEntity(dto);
        customer.setCreatedAt(LocalDateTime.now());
        this.customerRepository.save(customer);

        return ResponseDto.<CustomerDto>builder()
                .success(true)
                .message("Ok")
                .data(this.customerMapper.toDto(customer))
                .build();
    }

    @Override
    public ResponseDto<CustomerDto> get(Integer id) {
        return this.customerRepository.findByIdAndDeletedAtIsNull(id)
                .map(customer -> ResponseDto.<CustomerDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.customerMapper.toDto(customer))
                        .build())
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CustomerDto> update(CustomerDto dto, Integer id) {
        return this.customerRepository.findByIdAndDeletedAtIsNull(id)
                .map(customer -> {
                    customer.setUpdatedAt(LocalDateTime.now());
                    this.customerMapper.update(customer, dto);
                    this.customerRepository.save(customer);
                    return ResponseDto.<CustomerDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.customerMapper.toDto(customer))
                            .build();
                })
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CustomerDto> delete(Integer id) {
        return this.customerRepository.findByIdAndDeletedAtIsNull(id)
                .map(customer -> {
                    customer.setDeletedAt(LocalDateTime.now());
                    this.customerRepository.delete(customer);
                    return ResponseDto.<CustomerDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.customerMapper.toDto(customer))
                            .build();
                })
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<CustomerDto>> getAll() {
        List<Customer> list = this.customerRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<CustomerDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<CustomerDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.customerMapper::toDto).toList())
                .build();
    }
}
