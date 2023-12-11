package com.example.movie_rental_system.film_actor;

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
public class FilmActorService implements SimpleCrud<Integer, FilmActorDto> {
    private final FilmActorRepository filmActorRepository;
    private final FilmActorMapper filmActorMapper;

    @Override
    public ResponseDto<FilmActorDto> create(FilmActorDto dto) {
        FilmActor filmActor = this.filmActorMapper.toEntity(dto);
        filmActor.setCreatedAt(LocalDateTime.now());
        this.filmActorRepository.save(filmActor);

        return ResponseDto.<FilmActorDto>builder()
                .success(true)
                .message("Ok")
                .data(this.filmActorMapper.toDto(filmActor))
                .build();
    }

    @Override
    public ResponseDto<FilmActorDto> get(Integer id) {
        return this.filmActorRepository.findByIdAndDeletedAtIsNull(id)
                .map(filmActor -> ResponseDto.<FilmActorDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.filmActorMapper.toDto(filmActor))
                        .build())
                .orElse(ResponseDto.<FilmActorDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<FilmActorDto> update(FilmActorDto dto, Integer id) {
        return this.filmActorRepository.findByIdAndDeletedAtIsNull(id)
                .map(filmActor -> {
                    filmActor.setUpdatedAt(LocalDateTime.now());
                    this.filmActorMapper.update(filmActor, dto);
                    this.filmActorRepository.save(filmActor);
                    return ResponseDto.<FilmActorDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.filmActorMapper.toDto(filmActor))
                            .build();
                })
                .orElse(ResponseDto.<FilmActorDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<FilmActorDto> delete(Integer id) {
        return this.filmActorRepository.findByIdAndDeletedAtIsNull(id)
                .map(filmActor -> {
                    filmActor.setDeletedAt(LocalDateTime.now());
                    this.filmActorRepository.delete(filmActor);
                    return ResponseDto.<FilmActorDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.filmActorMapper.toDto(filmActor))
                            .build();
                })
                .orElse(ResponseDto.<FilmActorDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<FilmActorDto>> getAll() {
        List<FilmActor> list = this.filmActorRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<FilmActorDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<FilmActorDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.filmActorMapper::toDto).toList())
                .build();
    }
}
