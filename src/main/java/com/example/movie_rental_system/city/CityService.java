package com.example.movie_rental_system.city;

import com.example.movie_rental_system.category.Category;
import com.example.movie_rental_system.category.CategoryDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements SimpleCrud<Integer, CityDto> {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public ResponseDto<CityDto> create(CityDto dto) {
        City city = this.cityMapper.toEntity(dto);
        city.setCreatedAt(LocalDateTime.now());
        this.cityRepository.save(city);

        return ResponseDto.<CityDto>builder()
                .success(true)
                .message("Ok")
                .data(this.cityMapper.toDto(city))
                .build();
    }

    @Override
    public ResponseDto<CityDto> get(Integer id) {
        return this.cityRepository.findByIdAndDeletedAtIsNull(id)
                .map(city -> ResponseDto.<CityDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.cityMapper.toDto(city))
                        .build())
                .orElse(ResponseDto.<CityDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CityDto> update(CityDto dto, Integer id) {
        return this.cityRepository.findByIdAndDeletedAtIsNull(id)
                .map(city -> {
                    city.setUpdatedAt(LocalDateTime.now());
                    this.cityMapper.update(city, dto);
                    this.cityRepository.save(city);
                    return ResponseDto.<CityDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.cityMapper.toDto(city))
                            .build();
                })
                .orElse(ResponseDto.<CityDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CityDto> delete(Integer id) {
        return this.cityRepository.findByIdAndDeletedAtIsNull(id)
                .map(city -> {
                    city.setDeletedAt(LocalDateTime.now());
                    this.cityRepository.delete(city);
                    return ResponseDto.<CityDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.cityMapper.toDto(city))
                            .build();
                })
                .orElse(ResponseDto.<CityDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<CityDto>> getAll() {
        List<City> list = this.cityRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<CityDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<CityDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.cityMapper::toDto).toList())
                .build();
    }
}
