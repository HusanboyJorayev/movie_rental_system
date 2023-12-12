package com.example.movie_rental_system.staff;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.rental.RentalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("staff")
public class StaffController implements SimpleCrud<Integer, StaffDto> {

    private final StaffService staffService;

    @Override
    @PostMapping("/create")
    public ResponseDto<StaffDto> create(@RequestBody StaffDto dto) {
        return this.staffService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<StaffDto> get(@RequestParam Integer id) {
        return this.staffService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<StaffDto> update(@RequestBody StaffDto dto, @RequestParam Integer id) {
        return this.staffService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<StaffDto> delete(@RequestParam Integer id) {
        return this.staffService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<StaffDto>> getAll() {
        return this.staffService.getAll();
    }
}
