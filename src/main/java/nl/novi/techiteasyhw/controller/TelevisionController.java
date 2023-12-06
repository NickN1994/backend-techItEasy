package nl.novi.techiteasyhw.controller;

import nl.novi.techiteasyhw.service.TelevisionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;


    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }
}
