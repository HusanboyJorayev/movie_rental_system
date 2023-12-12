package com.example.movie_rental_system.store;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.staff.Staff;
import com.example.movie_rental_system.staff.StaffDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService implements SimpleCrud<Integer, StoreDto> {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;


    @Override
    public ResponseDto<StoreDto> create(StoreDto dto) {
        Store store = this.storeMapper.toEntity(dto);
        store.setCreatedAt(LocalDateTime.now());
        this.storeRepository.save(store);

        return ResponseDto.<StoreDto>builder()
                .success(true)
                .message("Ok")
                .data(this.storeMapper.toDto(store))
                .build();
    }

    @Override
    public ResponseDto<StoreDto> get(Integer id) {
        return this.storeRepository.findByIdAndDeletedAtIsNull(id)
                .map(store -> ResponseDto.<StoreDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.storeMapper.toDto(store))
                        .build())
                .orElse(ResponseDto.<StoreDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<StoreDto> update(StoreDto dto, Integer id) {
        return this.storeRepository.findByIdAndDeletedAtIsNull(id)
                .map(store -> {
                    store.setUpdatedAt(LocalDateTime.now());
                    this.storeMapper.update(store, dto);
                    this.storeRepository.save(store);
                    return ResponseDto.<StoreDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.storeMapper.toDto(store))
                            .build();
                })
                .orElse(ResponseDto.<StoreDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<StoreDto> delete(Integer id) {
        return this.storeRepository.findByIdAndDeletedAtIsNull(id)
                .map(store -> {
                    store.setDeletedAt(LocalDateTime.now());
                    this.storeRepository.delete(store);
                    return ResponseDto.<StoreDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.storeMapper.toDto(store))
                            .build();
                })
                .orElse(ResponseDto.<StoreDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<StoreDto>> getAll() {
        List<Store> list = this.storeRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<StoreDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<StoreDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.storeMapper::toDto).toList())
                .build();
    }
}
