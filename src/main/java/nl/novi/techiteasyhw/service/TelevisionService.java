package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }
}
