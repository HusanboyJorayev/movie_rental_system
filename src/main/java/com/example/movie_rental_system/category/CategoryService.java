package com.example.movie_rental_system.category;

import com.example.movie_rental_system.address.Address;
import com.example.movie_rental_system.address.AddressDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements SimpleCrud<Integer, CategoryDto> {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public ResponseDto<CategoryDto> create(CategoryDto dto) {
        Category category = this.categoryMapper.toEntity(dto);
        category.setCreatedAt(LocalDateTime.now());
        this.categoryRepository.save(category);

        return ResponseDto.<CategoryDto>builder()
                .success(true)
                .message("Ok")
                .data(this.categoryMapper.toDto(category))
                .build();
    }

    @Override
    public ResponseDto<CategoryDto> get(Integer id) {
        return this.categoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(category -> ResponseDto.<CategoryDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.categoryMapper.toDto(category))
                        .build())
                .orElse(ResponseDto.<CategoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CategoryDto> update(CategoryDto dto, Integer id) {
        return this.categoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(category -> {
                    category.setUpdatedAt(LocalDateTime.now());
                    this.categoryMapper.update(category, dto);
                    this.categoryRepository.save(category);
                    return ResponseDto.<CategoryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.categoryMapper.toDto(category))
                            .build();
                })
                .orElse(ResponseDto.<CategoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CategoryDto> delete(Integer id) {
        return this.categoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(category -> {
                    category.setDeletedAt(LocalDateTime.now());
                    this.categoryRepository.delete(category);
                    return ResponseDto.<CategoryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.categoryMapper.toDto(category))
                            .build();
                })
                .orElse(ResponseDto.<CategoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<CategoryDto>> getAll() {
        List<Category> list = this.categoryRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<CategoryDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<CategoryDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.categoryMapper::toDto).toList())
                .build();
    }
}
