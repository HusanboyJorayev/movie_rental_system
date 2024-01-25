package com.example.movie_rental_system.film;

import com.example.movie_rental_system.customer.CustomerDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Film")
@RequiredArgsConstructor
@RequestMapping("film")
public class FilmController implements SimpleCrud<Integer, FilmDto> {
    private final FilmService filmService;

    @Override
    @PostMapping("/create")
    public ResponseDto<FilmDto> create(@RequestBody FilmDto dto) {
        return this.filmService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<FilmDto> get(@RequestParam Integer id) {
        return this.filmService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<FilmDto> update(@RequestBody FilmDto dto, @RequestParam Integer id) {
        return this.filmService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<FilmDto> delete(@RequestParam Integer id) {
        return this.filmService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<FilmDto>> getAll() {
        return this.filmService.getAll();
    }
}
