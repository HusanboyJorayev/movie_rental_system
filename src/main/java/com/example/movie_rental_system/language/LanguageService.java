package com.example.movie_rental_system.language;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.inventory.Inventory;
import com.example.movie_rental_system.inventory.InventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService implements SimpleCrud<Integer, LanguageDto> {
    private final LanguageMapper languageMapper;
    private final LanguageRepository languageRepository;

    @Override
    public ResponseDto<LanguageDto> create(LanguageDto dto) {
        Language language = this.languageMapper.toEntity(dto);
        language.setCreatedAt(LocalDateTime.now());
        this.languageRepository.save(language);

        return ResponseDto.<LanguageDto>builder()
                .success(true)
                .message("Ok")
                .data(this.languageMapper.toDto(language))
                .build();
    }

    @Override
    public ResponseDto<LanguageDto> get(Integer id) {
        return this.languageRepository.findByIdAndDeletedAtIsNull(id)
                .map(language -> ResponseDto.<LanguageDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.languageMapper.toDto(language))
                        .build())
                .orElse(ResponseDto.<LanguageDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<LanguageDto> update(LanguageDto dto, Integer id) {
        return this.languageRepository.findByIdAndDeletedAtIsNull(id)
                .map(language -> {
                    language.setUpdatedAt(LocalDateTime.now());
                    this.languageMapper.update(language, dto);
                    this.languageRepository.save(language);
                    return ResponseDto.<LanguageDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.languageMapper.toDto(language))
                            .build();
                })
                .orElse(ResponseDto.<LanguageDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<LanguageDto> delete(Integer id) {
        return this.languageRepository.findByIdAndDeletedAtIsNull(id)
                .map(language -> {
                    language.setDeletedAt(LocalDateTime.now());
                    this.languageRepository.delete(language);
                    return ResponseDto.<LanguageDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.languageMapper.toDto(language))
                            .build();
                })
                .orElse(ResponseDto.<LanguageDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<LanguageDto>> getAll() {
        List<Language> list = this.languageRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<LanguageDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<LanguageDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.languageMapper::toDto).toList())
                .build();
    }
}
