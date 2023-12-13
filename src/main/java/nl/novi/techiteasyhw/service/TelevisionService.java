package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.Television.TelevisionInputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.exceptions.ExceptionController;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.Television;
import nl.novi.techiteasyhw.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public TelevisionOutputDto addTelevision(TelevisionInputDto dto) {
        Television tv = transferToTelevision(dto);
        repos.save(tv);
        return transferToDto(tv);
    }


    private Television transferToTelevision(TelevisionInputDto dto) {
        var television = new Television();
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

//        dto.setId(television.getId());
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
            throw new RecordNotFoundException ("geen televisie gevonden");
        }

    }

    public void assignRemoteControllerToTelevision (Long id, Long remoteControllerId) {

    }

}
