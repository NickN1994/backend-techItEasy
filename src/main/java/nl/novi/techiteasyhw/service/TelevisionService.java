package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.Television.TelevisionInputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.CiModule;
import nl.novi.techiteasyhw.model.RemoteController;
import nl.novi.techiteasyhw.model.Television;
import nl.novi.techiteasyhw.repository.CiModuleRepository;
import nl.novi.techiteasyhw.repository.RemoteControllerRepository;
import nl.novi.techiteasyhw.repository.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;
    private final RemoteControllerRepository remoteControllerRepository;

    private final CiModuleRepository ciModuleRepository;

    public TelevisionService(TelevisionRepository repos, RemoteControllerRepository remoteControllerRepository, CiModuleRepository ciModuleRepository) {

        this.repos = repos;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
    }

    public TelevisionOutputDto addTelevision(TelevisionInputDto dto) {
        Television tv = transferToTelevision(dto);
        repos.save(tv);
        return transferToDto(tv);
    }


    private Television transferToTelevision(TelevisionInputDto dto) {
        Television television = new Television();
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

    private TelevisionOutputDto transferToDto(Television television) {
        TelevisionOutputDto dto = new TelevisionOutputDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }


    public List<TelevisionOutputDto> getAllTelevisions() {
        List<Television> tvList = repos.findAll();
        List<TelevisionOutputDto> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionOutputDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }


    public TelevisionOutputDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            Television tv = televisionOptional.get();
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }

    }

    public void deleteTelevision(@RequestBody Long id) {

        repos.deleteById(id);

    }


    public TelevisionOutputDto updateTelevision(Long id, TelevisionInputDto inputDto) {
        Optional<Television> television = repos.findById(id);
        if (television.isPresent()) {
            Television television1 = television.get();
            if (inputDto.getType() != null) {
                television1.setType(inputDto.getType());
            }
            if (inputDto.getBrand() != null) {
                television1.setBrand(inputDto.getBrand());
            }
            if (inputDto.getName() != null) {
                television1.setName(inputDto.getName());
            }
            if (inputDto.getPrice() != null) {
                television1.setPrice(inputDto.getPrice());
            }
            if (inputDto.getAvailableSize() != null) {
                television1.setAvailableSize(inputDto.getAvailableSize());
            }
            if (inputDto.getRefreshRate() != null) {
                television1.setRefreshRate(inputDto.getRefreshRate());
            }
            if (inputDto.getScreenType() != null) {
                television1.setScreenType(inputDto.getScreenType());
            }
            if (inputDto.getBrand() != null) {
                television1.setBrand(inputDto.getBrand());
            }
            if (inputDto.getScreenQuality() != null) {
                television1.setScreenQuality(inputDto.getScreenQuality());
            }
            if (inputDto.getSmartTv() != null) {
                television1.setSmartTv(inputDto.getSmartTv());
            }
            if (inputDto.getWifi() != null) {
                television1.setWifi(inputDto.getWifi());
            }
            if (inputDto.getVoiceControl() != null) {
                television1.setVoiceControl(inputDto.getVoiceControl());
            }
            if (inputDto.getHdr() != null) {
                television1.setHdr(inputDto.getHdr());
            }
            if (inputDto.getBluetooth() != null) {
                television1.setBluetooth(inputDto.getBluetooth());
            }
            if (inputDto.getAmbiLight() != null) {
                television1.setAmbiLight(inputDto.getAmbiLight());
            }
            if (inputDto.getOriginalStock() != null) {
                television1.setOriginalStock(inputDto.getOriginalStock());
            }
            if (inputDto.getSold() != null) {
                television1.setSold(inputDto.getSold());
            }
            Television updatedTelevision = repos.save(television1);
            return transferToDto(updatedTelevision);
        } else {

            throw new RecordNotFoundException("geen televisie gevonden");

        }

    }
    public void assignRemoteControllerToTelevision (Long id, Long remoteControllerId){
        Optional<Television> optionalTelevision = repos.findById(id);
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(remoteControllerId);
        if (optionalTelevision.isPresent() && optionalRemoteController.isPresent()) {
            Television television = optionalTelevision.get();
            RemoteController remoteController = optionalRemoteController.get();

            television.setRemoteController(remoteController);
            repos.save(television);

        } else {
            throw new RecordNotFoundException("Geen televisie en remotecontroller gevonden");
        }

    }

    public void assignCIModuleToTelevision (Long id, Long ciModuleId) {
        Optional <Television> optionalTelevision = repos.findById(id);
        Optional <CiModule> optionalCiModule = ciModuleRepository.findById(ciModuleId);

        if (optionalTelevision.isPresent() && optionalCiModule.isPresent()) {
            Television television = optionalTelevision.get();
            CiModule ciModule = optionalCiModule.get();

            television.setCiModule(ciModule);
            repos.save(television);
        } else {
            throw new RecordNotFoundException("Geen televisie en cimodule gevonden");
        }
    }

}






