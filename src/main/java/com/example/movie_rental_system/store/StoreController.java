package com.example.movie_rental_system.store;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Store")
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController implements SimpleCrud<Integer, StoreDto> {
    private final StoreService storeService;

    @Override
    @PostMapping("/create")
    public ResponseDto<StoreDto> create(@RequestBody StoreDto dto) {
        return this.storeService.create(dto);
    }


    @Override
    @GetMapping("/get")
    public ResponseDto<StoreDto> get(@RequestParam Integer id) {
        return this.storeService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<StoreDto> update(@RequestBody StoreDto dto, @RequestParam Integer id) {
        return this.storeService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<StoreDto> delete(@RequestParam Integer id) {
        return this.storeService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<StoreDto>> getAll() {
        return this.storeService.getAll();
    }
}
