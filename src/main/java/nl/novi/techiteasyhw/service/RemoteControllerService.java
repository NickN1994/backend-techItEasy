package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerInputDto;
import nl.novi.techiteasyhw.repository.RemoteContollerRepository;
import org.springframework.stereotype.Service;

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

    }


}
