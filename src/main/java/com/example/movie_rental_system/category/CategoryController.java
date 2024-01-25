package com.example.movie_rental_system.category;

import com.example.movie_rental_system.address.AddressDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Category")
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController implements SimpleCrud<Integer,CategoryDto> {
    private final CategoryService categoryService;

    @Override
    @PostMapping("/create")
    public ResponseDto<CategoryDto> create(@RequestBody CategoryDto dto) {
        return this.categoryService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<CategoryDto> get(@RequestParam Integer id) {
        return this.categoryService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<CategoryDto> update(@RequestBody CategoryDto dto, @RequestParam Integer id) {
        return this.categoryService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<CategoryDto> delete(@RequestParam Integer id) {
        return this.categoryService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<CategoryDto>> getAll() {
        return this.categoryService.getAll();
    }
}
