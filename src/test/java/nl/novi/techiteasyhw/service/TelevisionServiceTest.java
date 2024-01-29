package nl.novi.techiteasyhw.service;

import nl.novi.techiteasyhw.dto.Television.TelevisionOutputDto;
import nl.novi.techiteasyhw.model.Television;
import nl.novi.techiteasyhw.repository.TelevisionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TelevisionServiceTest {

    @Mock
    TelevisionRepository televisionRepository;

    @InjectMocks
    TelevisionService televisionService;


    @Test
    @DisplayName("Should get all televisions")
    void getAllTelevisions() {

        // Arrange
        Television television = new Television();
        television.setId(1L);
        television.setName("LG");
        television.setPrice(400.00);

        when(televisionRepository.findAll()).thenReturn(List.of(television));
        // Act
        List<TelevisionOutputDto> result = televisionService.getAllTelevisions();


        //Assert
        assertEquals(1L, result.get(0).getId());

    }

    @Test
    @DisplayName("should delete tv")
    void deleteTelevision () {

        // Arrange
        Television television = new Television();
        television.setId(1L);
        television.setName("LG");
        television.setPrice(400.00);

        when(televisionRepository.findById(anyLong())).thenReturn(Optional.of(television));
        // Act
        televisionService.deleteTelevision(1L);

        //Assert
        verify(televisionRepository, Mockito.times(1)).deleteById(1L);
    }
}