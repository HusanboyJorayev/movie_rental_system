package com.example.movie_rental_system.inventory;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.film.FilmDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Inventory")
@RequiredArgsConstructor
@RequestMapping("inventory")
public class InventoryController implements SimpleCrud<Integer, InventoryDto> {
    private final InventoryService inventoryService;

    @Override
    @PostMapping("/create")
    public ResponseDto<InventoryDto> create(@RequestBody InventoryDto dto) {
        return this.inventoryService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<InventoryDto> get(@RequestParam Integer id) {
        return this.inventoryService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<InventoryDto> update(@RequestBody InventoryDto dto, @RequestParam Integer id) {
        return this.inventoryService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<InventoryDto> delete(@RequestParam Integer id) {
        return this.inventoryService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<InventoryDto>> getAll() {
        return this.inventoryService.getAll();
    }
}
