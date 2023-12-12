package com.example.movie_rental_system.staff;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.rental.Rental;
import com.example.movie_rental_system.rental.RentalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService implements SimpleCrud<Integer, StaffDto> {
    private final StaffMapper staffMapper;
    private final StaffRepository staffRepository;

    @Override
    public ResponseDto<StaffDto> create(StaffDto dto) {
        Staff staff = this.staffMapper.toEntity(dto);
        staff.setCreatedAt(LocalDateTime.now());
        this.staffRepository.save(staff);

        return ResponseDto.<StaffDto>builder()
                .success(true)
                .message("Ok")
                .data(this.staffMapper.toDto(staff))
                .build();
    }

    @Override
    public ResponseDto<StaffDto> get(Integer id) {
        return this.staffRepository.findByIdAndDeletedAtIsNull(id)
                .map(staff -> ResponseDto.<StaffDto>builder()
                        .success(true)
                        .message("Ok")
                        .data(this.staffMapper.toDto(staff))
                        .build())
                .orElse(ResponseDto.<StaffDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<StaffDto> update(StaffDto dto, Integer id) {
        return this.staffRepository.findByIdAndDeletedAtIsNull(id)
                .map(staff -> {
                    staff.setUpdatedAt(LocalDateTime.now());
                    this.staffMapper.update(staff, dto);
                    this.staffRepository.save(staff);
                    return ResponseDto.<StaffDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.staffMapper.toDto(staff))
                            .build();
                })
                .orElse(ResponseDto.<StaffDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<StaffDto> delete(Integer id) {
        return this.staffRepository.findByIdAndDeletedAtIsNull(id)
                .map(staff -> {
                    staff.setDeletedAt(LocalDateTime.now());
                    this.staffRepository.delete(staff);
                    return ResponseDto.<StaffDto>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.staffMapper.toDto(staff))
                            .build();
                })
                .orElse(ResponseDto.<StaffDto>builder()
                        .code(-1)
                        .message("Actor is not found")
                        .build());
    }

    @Override
    public ResponseDto<List<StaffDto>> getAll() {
        List<Staff> list = this.staffRepository.getAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<StaffDto>>builder()
                    .code(-1)
                    .message("Actors are not found")
                    .build();
        }
        return ResponseDto.<List<StaffDto>>builder()
                .success(true)
                .message("Ok")
                .data(list.stream().map(this.staffMapper::toDto).toList())
                .build();
    }
}
