package nl.novi.techiteasyhw.controller;

import jakarta.validation.Valid;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerInputDto;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerOutputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.dto.Wallbracket.WallbracketInputDto;
import nl.novi.techiteasyhw.model.RemoteController;
import nl.novi.techiteasyhw.service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;


    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @PostMapping ("/addremotecontroller")
    public ResponseEntity<RemoteControllerOutputDto> addRemoteController (@RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerOutputDto dto = remoteControllerService.addRemoteController(remoteControllerInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @GetMapping("/remotecontrollers")
    public ResponseEntity<List<RemoteControllerOutputDto>> getAllRemoteControllers () {
        List<RemoteControllerOutputDto> dtos;
        dtos = remoteControllerService.getAllRemoteControllers();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping ("/remotecontroller/{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRemoteController (Long id) {
        RemoteControllerOutputDto remoteController = remoteControllerService.getRemoteControllerById(id);

        return ResponseEntity.ok().body(remoteController);
    }

    @DeleteMapping ("remotecontroller/{id}")
    public ResponseEntity<Object> deleteRemoteController (@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/remotecontroller/{id}")
    public ResponseEntity<Object> updateRemoteController (@PathVariable Long id, @Valid @RequestBody RemoteControllerInputDto updateRemoteController) {
        RemoteControllerOutputDto dto = remoteControllerService.updateRemoteController(id, updateRemoteController);
        return ResponseEntity.ok().body(dto);
    }



}
