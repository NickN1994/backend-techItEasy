package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.dto.Wallbracket.WallbracketOutputDto;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.Television;
import nl.novi.techiteasyhw.model.TelevisionWallBracket;
import nl.novi.techiteasyhw.model.TelevisionWallBracketKey;
import nl.novi.techiteasyhw.model.WallBracket;
import nl.novi.techiteasyhw.repository.TelevisionRepository;
import nl.novi.techiteasyhw.repository.TelevisionWallBracketRepository;
import nl.novi.techiteasyhw.repository.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TelevisionWallBracketService {

    private TelevisionRepository televisionRepository;

    private WallBracketRepository wallBracketRepository;

    private TelevisionWallBracketRepository televisionWallBracketRepository;

    public TelevisionWallBracketService(TelevisionRepository televisionRepository, WallBracketRepository wallBracketRepository, TelevisionWallBracketRepository televisionWallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.wallBracketRepository = wallBracketRepository;
        this.televisionWallBracketRepository = televisionWallBracketRepository;
    }

    public Collection<TelevisionOutputDto> getTelevisionsByWallBracketId(Long wallBracketId) {
        Collection<TelevisionOutputDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallbrackets = TelevisionWallBracketRepository.findAllByWallBracketId(wallBracketId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            Television television = televisionWallbracket.getTelevision();
            TelevisionOutputDto televisionDto = new TelevisionOutputDto();

            televisionDto.setId(television.getId());
            televisionDto.setType(television.getType());
            televisionDto.setBrand(television.getBrand());
            televisionDto.setName(television.getName());
            televisionDto.setPrice(television.getPrice());
            televisionDto.setAvailableSize(television.getAvailableSize());
            televisionDto.setRefreshRate(television.getRefreshRate());
            televisionDto.setScreenType(television.getScreenType());
            televisionDto.setScreenQuality(television.getScreenQuality());
            televisionDto.setSmartTv(television.getSmartTv());
            televisionDto.setWifi(television.getWifi());
            televisionDto.setVoiceControl(television.getVoiceControl());
            televisionDto.setHdr(television.getHdr());
            televisionDto.setBluetooth(television.getBluetooth());
            televisionDto.setAmbiLight(television.getAmbiLight());
            televisionDto.setOriginalStock(television.getOriginalStock());
            televisionDto.setSold(television.getSold());

            dtos.add(televisionDto);
        }
        return dtos;
    }

    // Collection is de super klasse van zowel List als Set.
    public Collection<WallbracketOutputDto> getWallBracketsByTelevisionId(Long televisionId) {
        //We gebruiken hier Set om te voorkomen dat er dubbele entries in staan.
        Set<WallbracketOutputDto> dtos = new HashSet<>();
        List<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByTelevisionId(televisionId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            WallBracket wallBracket = televisionWallbracket.getWallBracket();
            var dto = new WallbracketOutputDto();

            dto.setId(wallBracket.getId());
            dto.setName(wallBracket.getName());
            dto.setSize(wallBracket.getSize());

            dto.setAdjustable(wallBracket.isAdjustable());
            dto.setPrice(wallBracket.getPrice());

            dtos.add(dto);
        }
        return dtos;
    }


    public TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        var televisionWallBracket = new TelevisionWallBracket();
        if (!televisionRepository.existsById(televisionId)) {throw new RecordNotFoundException();}
        Television television = televisionRepository.findById(televisionId).orElse(null);
        if (!wallBracketRepository.existsById(wallBracketId)) {throw new RecordNotFoundException();}
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElse(null);
        televisionWallBracket.setTelevision(television);
        televisionWallBracket.setWallBracket(wallBracket);
        TelevisionWallBracketKey id = new TelevisionWallBracketKey(televisionId, wallBracketId);
        televisionWallBracket.setId(id);
        televisionWallBracketRepository.save(televisionWallBracket);
        return id;
    }
}
