package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.CiModule.CiModuleInputDto;
import nl.novi.techiteasyhw.dto.CiModule.CiModuleOutputDto;
import nl.novi.techiteasyhw.exceptions.RecordNotFoundException;
import nl.novi.techiteasyhw.model.CiModule;
import nl.novi.techiteasyhw.repository.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private static final CiModuleRepository repos;

    public CiModuleService (CiModuleRepository repos) {
        this.repos = repos;
    }


    public CiModuleInputDto addCiModule (CiModuleInputDto dto) {
        CiModuleInputDto ciModule = transferToCiModule(dto);
        repos.save(ciModule);
        return transferToDto(ciModule);
    }


    private CiModuleInputDto transferToCiModule(CiModuleInputDto dto) {
        CiModuleInputDto ciModule = new CiModuleInputDto();
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    private CiModuleInputDto transferToDto(CiModuleInputDto ciModule) {
        CiModuleInputDto dto = new CiModuleInputDto();
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());
        return dto;
    }

    // hier heb ik een deze methode aangemaakt voor de output, omdat anders op regel 59 krijg ik de melding
    // dat ik de parameter op regel 47 moet aanpassen naar CiModule ciModule ipv CiModuleOutputDto ciModule, waarom?
    private CiModuleInputDto transferToOutputDto(CiModuleOutputDto ciModule) {
        CiModuleInputDto dto = new CiModuleInputDto();
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());
        return dto;
    }

    public List<CiModuleOutputDto> getAllCiModulen() {
        List<CiModule> CiModulenList = repos.findAll();
        List<CiModuleOutputDto> ciModuleOutputDtoList = new ArrayList<>();

        for (CiModule ciModule : CiModulenList) {
            CiModuleOutputDto dto = transferToOutputDto(ciModule); //waarom kan ik hier niet ciModule meegeven?
            ciModuleOutputDtoList.add(dto);

        }
        return ciModuleOutputDtoList;
    }

    public static CiModuleOutputDto getCiModuleById(Long id) {
        Optional<CiModule> ciModuleOptional = repos.findById(id);
        if (ciModuleOptional.isPresent()) {
            CiModule ciModule = ciModuleOptional.get();
            return transferToDto(ciModule);
        } else {
            throw new RecordNotFoundException("Geen Ci Module gevonden");
        }

    }

}
