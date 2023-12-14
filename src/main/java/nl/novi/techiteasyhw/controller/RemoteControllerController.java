package nl.novi.techiteasyhw.controller;

import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerInputDto;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerOutputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;


    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @PostMapping ("/addremotecontroller")
    public ResponseEntity<RemoteControllerInputDto> addRemoteController (@RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerInputDto dto = remoteControllerService.addRemoteController(remoteControllerInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @GetMapping('/remotecontrollers')
    public ResponseEntity<List<RemoteControllerOutputDto>> getAllRemoteControllers () {
        List<RemoteControllerOutputDto> dtos;
        dtos = remoteControllerService.getAllRemoteControllers();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping ('/remotecontroller/{id}')
    public ResponseEntity<RemoteControllerOutputDto> getRemoteController

}
