package com.example.movie_rental_system.customer;

import com.example.movie_rental_system.country.CountryDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Customer")
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController implements SimpleCrud<Integer,CustomerDto> {
    private final CustomerService customerService;

    @Override
    @PostMapping("/create")
    public ResponseDto<CustomerDto> create(@RequestBody CustomerDto dto) {
        return this.customerService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<CustomerDto> get(@RequestParam Integer id) {
        return this.customerService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<CustomerDto> update(@RequestBody CustomerDto dto, @RequestParam Integer id) {
        return this.customerService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<CustomerDto> delete(@RequestParam Integer id) {
        return this.customerService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<CustomerDto>> getAll() {
        return this.customerService.getAll();
    }
}
