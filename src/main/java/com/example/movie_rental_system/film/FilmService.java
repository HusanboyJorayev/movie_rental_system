package com.example.movie_rental_system.film;

import com.example.movie_rental_system.customer.Customer;
import com.example.movie_rental_system.customer.CustomerDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService implements SimpleCrud<Integer, FilmDto> {
    private final FilmMapper filmMapper;
    private final FilmRepository filmRepository;

    @Override
    public ResponseDto<FilmDto> create(FilmDto dto) {
        Film film = this.filmMapper.toEntity(dto);
        film.setCreatedAt(LocalDateTime.now());
        this.filmRepository.save(film);

        return ResponseDto.<FilmDto>builder()
                .success(true)
                .message("Ok")
                .data(this.filmMapper.toDto(film))
                .build();
    }

    @Override
    public ResponseDto<FilmDto> get(Integer id) {
        return this.filmRepository.findByIdAndDeletedAtIsNull(id)
                .map(film -> ResponseDto.<FilmDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.filmMapper.toDto(film))
                        .build())
                .orElse(ResponseDto.<FilmDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<FilmDto> update(FilmDto dto, Integer id) {
        return this.filmRepository.findByIdAndDeletedAtIsNull(id)
                .map(film -> {
                    film.setUpdatedAt(LocalDateTime.now());
                    this.filmMapper.update(film, dto);
                    this.filmRepository.save(film);
                    return ResponseDto.<FilmDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.filmMapper.toDto(film))
                            .build();
                })
                .orElse(ResponseDto.<FilmDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<FilmDto> delete(Integer id) {
        return this.filmRepository.findByIdAndDeletedAtIsNull(id)
                .map(film -> {
                    film.setDeletedAt(LocalDateTime.now());
                    this.filmRepository.delete(film);
                    return ResponseDto.<FilmDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.filmMapper.toDto(film))
                            .build();
                })
                .orElse(ResponseDto.<FilmDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<FilmDto>> getAll() {
        List<Film> list = this.filmRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<FilmDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<FilmDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.filmMapper::toDto).toList())
                .build();
    }
}
