package com.example.movie_rental_system.address;

import com.example.movie_rental_system.actor.Actor;
import com.example.movie_rental_system.actor.ActorDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements SimpleCrud<Integer, AddressDto> {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Override
    public ResponseDto<AddressDto> create(AddressDto dto) {
        Address address = this.addressMapper.toEntity(dto);
        address.setCreatedAt(LocalDateTime.now());
        this.addressRepository.save(address);

        return ResponseDto.<AddressDto>builder()
                .success(true)
                .message("Ok")
                .data(this.addressMapper.toDto(address))
                .build();
    }

    @Override
    public ResponseDto<AddressDto> get(Integer id) {
        return this.addressRepository.findByIdAndDeletedAtIsNull(id)
                .map(address -> ResponseDto.<AddressDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.addressMapper.toDto(address))
                        .build())
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<AddressDto> update(AddressDto dto, Integer id) {
        return this.addressRepository.findByIdAndDeletedAtIsNull(id)
                .map(address -> {
                    address.setUpdatedAt(LocalDateTime.now());
                    this.addressMapper.update(address, dto);
                    this.addressRepository.save(address);
                    return ResponseDto.<AddressDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.addressMapper.toDto(address))
                            .build();
                })
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<AddressDto> delete(Integer id) {
        return this.addressRepository.findByIdAndDeletedAtIsNull(id)
                .map(a -> {
                    a.setDeletedAt(LocalDateTime.now());
                    this.addressRepository.delete(a);
                    return ResponseDto.<AddressDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.addressMapper.toDto(a))
                            .build();
                })
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<AddressDto>> getAll() {
        List<Address> list = this.addressRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<AddressDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<AddressDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.addressMapper::toDto).toList())
                .build();
    }
}
