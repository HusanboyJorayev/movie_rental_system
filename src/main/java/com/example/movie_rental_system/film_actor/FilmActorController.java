package com.example.movie_rental_system.film_actor;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.film.FilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("filmActor")
public class FilmActorController implements SimpleCrud<Integer,FilmActorDto> {
    private final FilmActorService filmActorService;

    @Override
    @PostMapping("/create")
    public ResponseDto<FilmActorDto> create(@RequestBody FilmActorDto dto) {
        return this.filmActorService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<FilmActorDto> get(@RequestParam Integer id) {
        return this.filmActorService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<FilmActorDto> update(@RequestBody FilmActorDto dto, @RequestParam Integer id) {
        return this.filmActorService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<FilmActorDto> delete(@RequestParam Integer id) {
        return this.filmActorService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<FilmActorDto>> getAll() {
        return this.filmActorService.getAll();
    }
}
