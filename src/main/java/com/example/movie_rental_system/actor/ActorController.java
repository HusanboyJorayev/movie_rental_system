package com.example.movie_rental_system.actor;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("actor")
public class ActorController implements SimpleCrud<Integer, ActorDto> {
    private final ActorService actorService;

    @Override
    @PostMapping("/create")
    public ResponseDto<ActorDto> create(@RequestBody ActorDto dto) {
        return this.actorService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<ActorDto> get(@RequestParam Integer id) {
        return this.actorService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<ActorDto> update(@RequestBody ActorDto dto, @RequestParam Integer id) {
        return this.actorService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<ActorDto> delete(@RequestParam Integer id) {
        return this.actorService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<ActorDto>> getAll() {
        return this.actorService.getAll();
    }
}
