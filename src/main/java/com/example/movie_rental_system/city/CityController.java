package com.example.movie_rental_system.city;

import com.example.movie_rental_system.category.CategoryDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CityController implements SimpleCrud<Integer,CityDto> {
    private final CityService cityService;

    @Override
    @PostMapping("/create")
    public ResponseDto<CityDto> create(@RequestBody CityDto dto) {
        return this.cityService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<CityDto> get(@RequestParam Integer id) {
        return this.cityService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<CityDto> update(@RequestBody CityDto dto, @RequestParam Integer id) {
        return this.cityService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<CityDto> delete(@RequestParam Integer id) {
        return this.cityService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<CityDto>> getAll() {
        return this.cityService.getAll();
    }
}
