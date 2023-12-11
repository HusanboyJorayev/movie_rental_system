package com.example.movie_rental_system.country;

import com.example.movie_rental_system.city.City;
import com.example.movie_rental_system.city.CityDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements SimpleCrud<Integer, CountryDto> {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public ResponseDto<CountryDto> create(CountryDto dto) {
        Country country = this.countryMapper.toEntity(dto);
        country.setCreatedAt(LocalDateTime.now());
        this.countryRepository.save(country);

        return ResponseDto.<CountryDto>builder()
                .success(true)
                .message("Ok")
                .data(this.countryMapper.toDto(country))
                .build();
    }

    @Override
    public ResponseDto<CountryDto> get(Integer id) {
        return this.countryRepository.findByIdAndDeletedAtIsNull(id)
                .map(country -> ResponseDto.<CountryDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.countryMapper.toDto(country))
                        .build())
                .orElse(ResponseDto.<CountryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CountryDto> update(CountryDto dto, Integer id) {
        return this.countryRepository.findByIdAndDeletedAtIsNull(id)
                .map(country -> {
                    country.setUpdatedAt(LocalDateTime.now());
                    this.countryMapper.update(country, dto);
                    this.countryRepository.save(country);
                    return ResponseDto.<CountryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.countryMapper.toDto(country))
                            .build();
                })
                .orElse(ResponseDto.<CountryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<CountryDto> delete(Integer id) {
        return this.countryRepository.findByIdAndDeletedAtIsNull(id)
                .map(country -> {
                    country.setDeletedAt(LocalDateTime.now());
                    this.countryRepository.delete(country);
                    return ResponseDto.<CountryDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.countryMapper.toDto(country))
                            .build();
                })
                .orElse(ResponseDto.<CountryDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<CountryDto>> getAll() {
        List<Country> list = this.countryRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<CountryDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<CountryDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.countryMapper::toDto).toList())
                .build();
    }
}
