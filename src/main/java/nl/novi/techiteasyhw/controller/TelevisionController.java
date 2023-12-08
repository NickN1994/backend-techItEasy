package nl.novi.techiteasyhw.controller;

import nl.novi.techiteasyhw.dto.TelevisionInputDto;
import nl.novi.techiteasyhw.dto.TelevisionOutputDto;
import nl.novi.techiteasyhw.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;


    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @PostMapping("/addtv")
    public ResponseEntity<TelevisionOutputDto> addTelevision (@RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionOutputDto dto = televisionService.addTelevision(televisionInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionInputDto>> getAllTelevesions (@RequestParam (value = "brand", required = false) Optional<String> brand) {
        List<TelevisionOutputDto> dtos;

        if (brand.isEmpty()) {
            dtos = televisionService.getAllTelevisions();
        } else {
            dtos = televisionService.getAllTelevisionsByBrand(brand.get());
        }

        return

    }

}
