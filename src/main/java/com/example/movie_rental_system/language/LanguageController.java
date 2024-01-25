package com.example.movie_rental_system.language;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.inventory.InventoryDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Language")
@RequiredArgsConstructor
@RequestMapping("language")
public class LanguageController implements SimpleCrud<Integer, LanguageDto> {
    private final LanguageService languageService;

    @Override
    @PostMapping("/create")
    public ResponseDto<LanguageDto> create(@RequestBody LanguageDto dto) {
        return this.languageService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<LanguageDto> get(@RequestParam Integer id) {
        return this.languageService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<LanguageDto> update(@RequestBody LanguageDto dto, @RequestParam Integer id) {
        return this.languageService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<LanguageDto> delete(@RequestParam Integer id) {
        return this.languageService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<LanguageDto>> getAll() {
        return this.languageService.getAll();
    }
}
