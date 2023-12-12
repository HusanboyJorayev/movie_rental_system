package com.example.movie_rental_system.inventory;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.film.Film;
import com.example.movie_rental_system.film.FilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService implements SimpleCrud<Integer,InventoryDto> {
    private final InventoryMapper inventoryMapper;
    private final InventoryRepository inventoryRepository;

    @Override
    public ResponseDto<InventoryDto> create(InventoryDto dto) {
        Inventory inventory = this.inventoryMapper.toEntity(dto);
        inventory.setCreatedAt(LocalDateTime.now());
        this.inventoryRepository.save(inventory);

        return ResponseDto.<InventoryDto>builder()
                .success(true)
                .message("Ok")
                .data(this.inventoryMapper.toDto(inventory))
                .build();
    }

    @Override
    public ResponseDto<InventoryDto> get(Integer id) {
        return this.inventoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(inventory -> ResponseDto.<InventoryDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.inventoryMapper.toDto(inventory))
                        .build())
                .orElse(ResponseDto.<InventoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<InventoryDto> update(InventoryDto dto, Integer id) {
        return this.inventoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(inventory -> {
                    inventory.setUpdatedAt(LocalDateTime.now());
                    this.inventoryMapper.update(inventory, dto);
                    this.inventoryRepository.save(inventory);
                    return ResponseDto.<InventoryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.inventoryMapper.toDto(inventory))
                            .build();
                })
                .orElse(ResponseDto.<InventoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<InventoryDto> delete(Integer id) {
        return this.inventoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(inventory -> {
                    inventory.setDeletedAt(LocalDateTime.now());
                    this.inventoryRepository.delete(inventory);
                    return ResponseDto.<InventoryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.inventoryMapper.toDto(inventory))
                            .build();
                })
                .orElse(ResponseDto.<InventoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<InventoryDto>> getAll() {
        List<Inventory> list = this.inventoryRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<InventoryDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<InventoryDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.inventoryMapper::toDto).toList())
                .build();
    }
}
