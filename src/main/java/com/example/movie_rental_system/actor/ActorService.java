package com.example.movie_rental_system.actor;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorService implements SimpleCrud<Integer, ActorDto> {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public ResponseDto<ActorDto> create(ActorDto dto) {
        Actor actor = this.actorMapper.toEntity(dto);
        actor.setCreatedAt(LocalDateTime.now());
        this.actorRepository.save(actor);

        return ResponseDto.<ActorDto>builder()
                .success(true)
                .message("Ok")
                .data(this.actorMapper.toDto(actor))
                .build();
    }

    @Override
    public ResponseDto<ActorDto> get(Integer id) {

        return this.actorRepository.findByIdAndDeletedAtIsNull(id)
                .map(actor -> ResponseDto.<ActorDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.actorMapper.toDto(actor))
                        .build())
                .orElse(ResponseDto.<ActorDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());

    }

    @Override
    public ResponseDto<ActorDto> update(ActorDto dto, Integer id) {

        return this.actorRepository.findByIdAndDeletedAtIsNull(id)
                .map(actor -> {
                    actor.setUpdatedAt(LocalDateTime.now());
                    this.actorMapper.update(actor, dto);
                    this.actorRepository.save(actor);
                    return ResponseDto.<ActorDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.actorMapper.toDto(actor))
                            .build();
                })
                .orElse(ResponseDto.<ActorDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<ActorDto> delete(Integer id) {
        return this.actorRepository.findByIdAndDeletedAtIsNull(id)
                .map(actor -> {
                    actor.setDeletedAt(LocalDateTime.now());
                    this.actorRepository.delete(actor);
                    return ResponseDto.<ActorDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.actorMapper.toDto(actor))
                            .build();
                })
                .orElse(ResponseDto.<ActorDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<ActorDto>> getAll() {
        List<Actor> list = this.actorRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<ActorDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<ActorDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.actorMapper::toDto).toList())
                .build();
    }
}
