package nl.novi.techiteasyhw.controller;

import jakarta.validation.Valid;
import nl.novi.techiteasyhw.dto.Television.TelevisionInputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.model.Television;
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
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevesions (@RequestParam (value = "brand", required = false) Optional<String> brand) {
        List<TelevisionOutputDto> dtos;
            dtos = televisionService.getAllTelevisions();
        return ResponseEntity.ok().body(dtos);

    }


    @GetMapping("/television/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision (@PathVariable ("id") Long id) {
        TelevisionOutputDto television = televisionService.getTelevisionById(id);

        return ResponseEntity.ok().body(television);
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {

        televisionService.deleteTelevision(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto newTelevision) {

        TelevisionOutputDto dto = televisionService.updateTelevision(id, newTelevision);

        return ResponseEntity.ok().body(dto);
    }



}
