package nl.novi.techiteasyhw.service;

import jakarta.validation.Valid;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerInputDto;
import nl.novi.techiteasyhw.dto.RemoteController.RemoteControllerOutputDto;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.RemoteController;

import nl.novi.techiteasyhw.repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository repos;


    public RemoteControllerService(RemoteControllerRepository repos) {
        this.repos = repos;
    }

    public RemoteControllerOutputDto addRemoteController(RemoteControllerInputDto dto) {
        RemoteController remoteController = transferToRemoteController(dto);
        repos.save(remoteController);
        return transferToDto(remoteController);
    }

    private RemoteController transferToRemoteController(RemoteControllerInputDto dto) {
        RemoteController remoteController = new RemoteController();
        remoteController.setName(dto.getName());
        remoteController.setBrand(dto.getBrand());
        remoteController.setPrice(dto.getPrice());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }

    private RemoteControllerOutputDto transferToDto(RemoteController remoteController) {
        RemoteControllerOutputDto dto = new RemoteControllerOutputDto();
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

    public RemoteControllerOutputDto getRemoteControllerById(Long id) {
        Optional<RemoteController> remoteControllerOptional = repos.findById(id);
        if (remoteControllerOptional.isPresent()) {
            RemoteController remoteController = remoteControllerOptional.get();
            return transferToDto(remoteController);
        } else {
            throw new RecordNotFoundException("Geen remotecontroller gevonden");
        }

    }

    public void deleteRemoteController(Long id) {
        repos.deleteById(id);
    }

    public RemoteControllerOutputDto updateRemoteController (Long id, @Valid RemoteControllerInputDto remoteControllerInputDto) {
        Optional<RemoteController> remoteController = repos.findById(id);
        if (remoteController.isPresent()) {
            RemoteController remoteController1 = remoteController.get();
            if (remoteControllerInputDto.getName() != null) {
                remoteController1.setName(remoteControllerInputDto.getName());
            }
            if (remoteControllerInputDto.getBrand() != null) {
                remoteController1.setBrand(remoteControllerInputDto.getBrand());
            }
            if (remoteControllerInputDto.getBatteryType() != null) {
                remoteController1.setBatteryType(remoteControllerInputDto.getBatteryType());
            }
            if (remoteControllerInputDto.getCompatibleWith() != null) {
                remoteController1.setCompatibleWith(remoteControllerInputDto.getCompatibleWith());
            }
            if (remoteControllerInputDto.getPrice() != null) {
                remoteController1.setPrice(remoteControllerInputDto.getPrice());
            }
            if (remoteControllerInputDto.getOriginalStock() != null) {
                remoteController1.setOriginalStock(remoteControllerInputDto.getOriginalStock());
            }
            RemoteController updatedRemoteController = repos.save(remoteController1);
            return transferToDto(updatedRemoteController);
        } else {
            throw new RecordNotFoundException("geen remotecontroller gevonden ");
        }

    }


}
