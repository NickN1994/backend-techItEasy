package nl.novi.techiteasyhw.controller;

import jakarta.validation.Valid;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerOutputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionInputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.dto.Wallbracket.WallbracketInputDto;
import nl.novi.techiteasyhw.dto.Wallbracket.WallbracketOutputDto;
import nl.novi.techiteasyhw.service.WallbracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WallbracketController {

    private final WallbracketService wallbracketService;


    public WallbracketController(WallbracketService wallbracketService) {
        this.wallbracketService = wallbracketService;
    }

    @PostMapping("/addwallbracket")
    public ResponseEntity<WallbracketOutputDto> addWallBracket (@RequestBody WallbracketInputDto wallbracketInputDto) {
        WallbracketOutputDto dto = wallbracketService.addWallBracket(wallbracketInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @GetMapping("/wallbrackets")
    public ResponseEntity<List<WallbracketOutputDto>> getAllWallBrackets () {
        List <WallbracketOutputDto> dtos;
        dtos = wallbracketService.getAllWallBrackets();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/wallbracket/{id}")
    public ResponseEntity <WallbracketOutputDto> getWallbracket (Long id) {
        WallbracketOutputDto wallBracket = wallbracketService.getWallBracketById(id);
        return ResponseEntity.ok().body(wallBracket);
    }

    @DeleteMapping("/wallbracket/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable Long id) {

       wallbracketService.deleteWallBracket(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/wallbracket/{id}")
    public ResponseEntity<Object> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallbracketInputDto updateWallBracket) {

        WallbracketOutputDto dto = wallbracketService.updateWallBracket(id, updateWallBracket);

        return ResponseEntity.ok().body(dto);
    }
}


