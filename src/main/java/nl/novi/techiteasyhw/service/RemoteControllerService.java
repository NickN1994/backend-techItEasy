package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerInputDto;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerOutputDto;
import nl.novi.techiteasyhw.model.RemoteController;
import nl.novi.techiteasyhw.repository.RemoteContollerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteContollerRepository repos;


    public RemoteControllerService(RemoteContollerRepository repos) {
        this.repos = repos;
    }

    public RemoteControllerInputDto addRemoteController(RemoteControllerInputDto dto) {
        RemoteControllerInputDto remoteController = transferToRemoteController(dto);
        repos.save(remoteController);
        return transferToDto(remoteController);
    }

    private RemoteControllerInputDto transferToRemoteController(RemoteControllerInputDto dto) {
        RemoteControllerInputDto remoteController = new RemoteControllerInputDto();
        remoteController.setName(dto.getName());
        remoteController.setBrand(dto.getBrand());
        remoteController.setPrice(dto.getPrice());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }

    private RemoteControllerInputDto transferToDto(RemoteControllerInputDto remoteController) {
        RemoteControllerInputDto dto = new RemoteControllerInputDto();
        dto.setName(remoteController.getName());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setOriginalStock(remoteController.getOriginalStock());
    return dto;
    }


    public List<RemoteControllerOutputDto> getAllRemoteControllers() {
        List<RemoteController> remoteControllerList = repos.findAll();
        List<RemoteControllerOutputDto> remoteControllerOutputDtoList = new ArrayList<>();

        for (RemoteController remoteController : remoteControllerList) {
            RemoteControllerOutputDto dto = transferToDto(remoteController);
            remoteControllerOutputDtoList.add(dto);

        }
        return remoteControllerOutputDtoList;
    }
}
