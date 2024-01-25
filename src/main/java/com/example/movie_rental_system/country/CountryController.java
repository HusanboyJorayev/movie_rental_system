package com.example.movie_rental_system.country;

import com.example.movie_rental_system.city.CityDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Country")
@RequiredArgsConstructor
@RequestMapping("country")
public class CountryController implements SimpleCrud<Integer, CountryDto> {
    private final CountryService countryService;

    @Override
    @PostMapping("/create")
    public ResponseDto<CountryDto> create(@RequestBody CountryDto dto) {
        return this.countryService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<CountryDto> get(@RequestParam Integer id) {
        return this.countryService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<CountryDto> update(@RequestBody CountryDto dto, @RequestParam Integer id) {
        return this.countryService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<CountryDto> delete(@RequestParam Integer id) {
        return this.countryService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<CountryDto>> getAll() {
        return this.countryService.getAll();
    }
}
