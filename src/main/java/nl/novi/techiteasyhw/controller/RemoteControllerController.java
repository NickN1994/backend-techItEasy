package nl.novi.techiteasyhw.controller;

import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerInputDto;
import nl.novi.techiteasyhw.service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
