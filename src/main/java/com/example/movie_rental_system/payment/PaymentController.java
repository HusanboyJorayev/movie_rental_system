package com.example.movie_rental_system.payment;

import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import com.example.movie_rental_system.language.LanguageDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Payment")
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentController implements SimpleCrud<Integer, PaymentDto> {

    private final PaymentService paymentService;

    @Override
    @PostMapping("/create")
    public ResponseDto<PaymentDto> create(@RequestBody PaymentDto dto) {
        return this.paymentService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<PaymentDto> get(@RequestParam Integer id) {
        return this.paymentService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<PaymentDto> update(@RequestBody PaymentDto dto, @RequestParam Integer id) {
        return this.paymentService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<PaymentDto> delete(@RequestParam Integer id) {
        return this.paymentService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<PaymentDto>> getAll() {
        return this.paymentService.getAll();
    }
}
