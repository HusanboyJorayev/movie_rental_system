package com.example.movie_rental_system.rental;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.payment.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rental")
public class RentalController implements SimpleCrud<Integer, RentalDto> {
    private final RentalService rentalService;

    @Override
    @PostMapping("/create")
    public ResponseDto<RentalDto> create(@RequestBody RentalDto dto) {
        return this.rentalService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<RentalDto> get(@RequestParam Integer id) {
        return this.rentalService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<RentalDto> update(@RequestBody RentalDto dto, @RequestParam Integer id) {
        return this.rentalService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<RentalDto> delete(@RequestParam Integer id) {
        return this.rentalService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<RentalDto>> getAll() {
        return this.rentalService.getAll();
    }
}
