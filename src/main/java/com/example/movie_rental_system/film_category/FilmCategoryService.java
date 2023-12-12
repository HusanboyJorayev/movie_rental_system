package com.example.movie_rental_system.film_category;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.film_actor.FilmActor;
import com.example.movie_rental_system.film_actor.FilmActorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmCategoryService implements SimpleCrud<Integer, FilmCategoryDto> {
    private final FilmCategoryMapper filmCategoryMapper;
    private final FilmCategoryRepository filmCategoryRepository;

    @Override
    public ResponseDto<FilmCategoryDto> create(FilmCategoryDto dto) {
        FilmCategory filmCategory = this.filmCategoryMapper.toEntity(dto);
        filmCategory.setCreatedAt(LocalDateTime.now());
        this.filmCategoryRepository.save(filmCategory);

        return ResponseDto.<FilmCategoryDto>builder()
                .success(true)
                .message("Ok")
                .data(this.filmCategoryMapper.toDto(filmCategory))
                .build();
    }

    @Override
    public ResponseDto<FilmCategoryDto> get(Integer id) {
        return this.filmCategoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(filmCategory -> ResponseDto.<FilmCategoryDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.filmCategoryMapper.toDto(filmCategory))
                        .build())
                .orElse(ResponseDto.<FilmCategoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<FilmCategoryDto> update(FilmCategoryDto dto, Integer id) {
        return this.filmCategoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(filmCategory -> {
                    filmCategory.setUpdatedAt(LocalDateTime.now());
                    this.filmCategoryMapper.update(filmCategory, dto);
                    this.filmCategoryRepository.save(filmCategory);
                    return ResponseDto.<FilmCategoryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.filmCategoryMapper.toDto(filmCategory))
                            .build();
                })
                .orElse(ResponseDto.<FilmCategoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<FilmCategoryDto> delete(Integer id) {
        return this.filmCategoryRepository.findByIdAndDeletedAtIsNull(id)
                .map(filmCategory -> {
                    filmCategory.setDeletedAt(LocalDateTime.now());
                    this.filmCategoryRepository.delete(filmCategory);
                    return ResponseDto.<FilmCategoryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.filmCategoryMapper.toDto(filmCategory))
                            .build();
                })
                .orElse(ResponseDto.<FilmCategoryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<FilmCategoryDto>> getAll() {
        List<FilmCategory> list = this.filmCategoryRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<FilmCategoryDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<FilmCategoryDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.filmCategoryMapper::toDto).toList())
                .build();
    }
}
