package com.example.movie_rental_system.address;

import com.example.movie_rental_system.actor.ActorDto;
import com.example.movie_rental_system.dto.ResponseDto;
import com.example.movie_rental_system.dto.SimpleCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Address")
@RequiredArgsConstructor
@RequestMapping("address")
public class AddressController implements SimpleCrud<Integer, AddressDto> {
    private final AddressService addressService;

    @Override
    @PostMapping("/create")
    public ResponseDto<AddressDto> create(@RequestBody AddressDto dto) {
        return this.addressService.create(dto);
    }

    @Override
    @GetMapping("/get")
    public ResponseDto<AddressDto> get(@RequestParam Integer id) {
        return this.addressService.get(id);
    }

    @Override
    @PutMapping("/update")
    public ResponseDto<AddressDto> update(@RequestBody AddressDto dto, @RequestParam Integer id) {
        return this.addressService.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseDto<AddressDto> delete(@RequestParam Integer id) {
        return this.addressService.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDto<List<AddressDto>> getAll() {
        return this.addressService.getAll();
    }
}
