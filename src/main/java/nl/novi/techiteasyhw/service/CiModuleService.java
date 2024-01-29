package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.CiModule.CiModuleInputDto;
import nl.novi.techiteasyhw.dto.CiModule.CiModuleOutputDto;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.CiModule;
import nl.novi.techiteasyhw.repository.CiModuleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository repos;

    public CiModuleService (CiModuleRepository repos) {
        this.repos = repos;
    }


    public CiModuleOutputDto addCiModule (CiModuleInputDto dto) {
        CiModule ciModule = transferToCiModule(dto);
        repos.save(ciModule);
        return transferToDto(ciModule);
    }


    private CiModule transferToCiModule(CiModuleInputDto dto) {
        CiModule ciModule = new CiModule();
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    private CiModuleOutputDto transferToDto(CiModule ciModule) {
        CiModuleOutputDto dto = new CiModuleOutputDto();
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());
        return dto;
    }

    public List<CiModuleOutputDto> getAllCiModulen() {
        List<CiModule> CiModulenList = repos.findAll();
        List<CiModuleOutputDto> ciModuleOutputDtoList = new ArrayList<>();

        for (CiModule ciModule : CiModulenList) {
            CiModuleOutputDto dto = transferToDto(ciModule); //waarom kan ik hier niet ciModule meegeven?
            ciModuleOutputDtoList.add(dto);

        }
        return ciModuleOutputDtoList;
    }

    public CiModuleOutputDto getCiModuleById(Long id) {
        Optional<CiModule> ciModuleOptional = repos.findById(id);
        if (ciModuleOptional.isPresent()) {
            CiModule ciModule = ciModuleOptional.get();
            return transferToDto(ciModule);
        } else {
            throw new RecordNotFoundException("Geen Ci Module gevonden");
        }
    }


    public void deleteCiModule(@RequestBody Long id) {
        repos.deleteById(id);
        // moet je hier geen return geven of bevestigin? Wat als opgegeven id er niet is? if statement maken?
    }


    public CiModuleOutputDto updateCiModule(Long id, CiModuleInputDto ciModuleInputDto) {
        Optional<CiModule> ciModule = repos.findById(id);
        if (ciModule.isPresent()) {
            CiModule ciModule1 = ciModule.get();
            if (ciModuleInputDto.getName() != null ) {
                ciModule1.setName(ciModuleInputDto.getName());
            }
            if (ciModuleInputDto.getType() != null ) {
                ciModule1.setType(ciModuleInputDto.getType());
            }
            if (ciModuleInputDto.getPrice() != null ) {
                ciModule1.setPrice(ciModuleInputDto.getPrice());
            }
            CiModule updatedCiModule = repos.save(ciModule1);
            return transferToDto(updatedCiModule);
        } else {
            throw new RecordNotFoundException("geen cimodule gevonden");
        }

    }
}
