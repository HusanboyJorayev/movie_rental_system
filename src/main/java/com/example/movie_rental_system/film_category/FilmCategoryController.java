package com.example.movie_rental_system.film_category;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.film_actor.FilmActorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("filmCategory")
public class FilmCategoryController implements SimpleCrud<Integer, FilmCategoryDto> {
    private final FilmCategoryService filmCategoryService;

    @Override
    @PostMapping("/create")
    public ResponseDto<FilmCategoryDto> create(@RequestBody FilmCategoryDto dto) {
        return this.filmCategoryService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<FilmCategoryDto> get(@RequestParam Integer id) {
        return this.filmCategoryService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<FilmCategoryDto> update(@RequestBody FilmCategoryDto dto, @RequestParam Integer id) {
        return this.filmCategoryService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<FilmCategoryDto> delete(@RequestParam Integer id) {
        return this.filmCategoryService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<FilmCategoryDto>> getAll() {
        return this.filmCategoryService.getAll();
    }
}
