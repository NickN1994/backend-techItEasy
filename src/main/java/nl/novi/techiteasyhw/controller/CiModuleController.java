package nl.novi.techiteasyhw.controller;

import nl.novi.techiteasyhw.dto.CiModule.CiModuleInputDto;
import nl.novi.techiteasyhw.dto.CiModule.CiModuleOutputDto;
import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.repository.CiModuleRepository;
import nl.novi.techiteasyhw.service.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CiModuleController {

    private final CiModuleService ciModuleService;

    public CiModuleController (CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @PostMapping("/addcimodule")
    public ResponseEntity <CiModuleInputDto> addCiModule (@RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModuleInputDto dto = ciModuleService.addCiModule(ciModuleInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @GetMapping("/cimodulen")
    public ResponseEntity <List<CiModuleOutputDto>> getAllCiModulen (){
        List<CiModuleOutputDto> dtos;
        dtos = ciModuleService.getAllCiModulen();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/cimodule/{id}")
    public ResponseEntity<CiModuleOutputDto> getCiModule (@PathVariable ("id") Long id) {
        CiModuleOutputDto ciModule = CiModuleService.getCiModuleById(id);

    }
}
