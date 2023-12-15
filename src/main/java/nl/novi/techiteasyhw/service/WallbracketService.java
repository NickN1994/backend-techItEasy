package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.CiModule.CiModuleOutputDto;
import nl.novi.techiteasyhw.dto.Wallbracket.WallbracketInputDto;
import nl.novi.techiteasyhw.dto.Wallbracket.WallbracketOutputDto;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.WallBracket;
import nl.novi.techiteasyhw.repository.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallbracketService {

    private final WallBracketRepository repos;

    public WallbracketService(WallBracketRepository repos) {
        this.repos = repos;
    }

    public WallbracketOutputDto addWallBracket(WallbracketInputDto dto) {
        WallBracket wallBracket = transferToWallBracket(dto);
          repos.save(wallBracket);
        return transferToDto(wallBracket);
    }

    private WallBracket transferToWallBracket(WallbracketInputDto dto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setName(dto.getName());
        wallBracket.setPrice(dto.getPrice());
        wallBracket.setSize(dto.getSize());
        wallBracket.setAdjustable(dto.isAdjustable());

        return wallBracket;
    }
//moet je hier input of output gebruiken, wnat hier gaat het object weer terug naar dto om naar de client
    // te gaan, dus output?
    private WallbracketOutputDto transferToDto(WallBracket wallBracket) {
        WallbracketOutputDto dto = new WallbracketOutputDto();
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());
        dto.setSize(wallBracket.getSize());
        dto.setAjustable(wallBracket.isAdjustable());

        return dto;
    }

    public List<WallbracketOutputDto> getAllWallBrackets() {
        List<WallBracket> WallBracketList = repos.findAll();
        List <WallbracketOutputDto> wallbracketOutputList = new ArrayList<>();

        for (WallBracket wallBracket : WallBracketList) {
            WallbracketOutputDto dto = transferToDto(wallBracket);
            wallbracketOutputList.add(dto);

        }
        return wallbracketOutputList;
    }


    public WallbracketOutputDto getWallBracketById(Long id) {
        Optional<WallBracket> wallBracketOptional = repos.findById(id);
        if (wallBracketOptional.isPresent()) {
            WallBracket wallBracket = wallBracketOptional.get();
            return transferToDto(wallBracket);
        } else {
            throw new RecordNotFoundException("Geen wallbracket gevonden");
        }
    }

    public void deleteWallBracket(Long id) {
        repos.deleteById(id);
    }

    public WallbracketOutputDto updateWallBracket(Long id, WallbracketInputDto wallbracketInputDto) {
        Optional<WallBracket> wallBracket = repos.findById(id);
        if (wallBracket.isPresent()) {
            WallBracket wallBracket1 = wallBracket.get();
            if (wallbracketInputDto.getName() != null ) {
                    wallBracket1.setName(wallbracketInputDto.getName());
            }
            if (wallbracketInputDto.getSize() != null ) {
                wallBracket1.setSize(wallbracketInputDto.getSize());
            }
            if (wallbracketInputDto.getPrice() != null ) {
                wallBracket1.setPrice(wallbracketInputDto.getPrice());
            }
            if (wallbracketInputDto.isAdjustable() != null ) {
                wallBracket1.setAdjustable(wallbracketInputDto.isAdjustable());
            }
            WallBracket updatedWallBracket = repos.save(wallBracket1);
            return transferToDto(updatedWallBracket);
        } else {
            throw new RecordNotFoundException ("Geen wallbracket gevonden");
        }
    }
}
