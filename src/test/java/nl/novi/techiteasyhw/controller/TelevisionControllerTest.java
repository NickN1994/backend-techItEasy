package nl.novi.techiteasyhw.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.jupiter.api.Assertions.*;


// interegation test

// ondrestaande altijd gebruiken
// dan nieuwe application.properties maken
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("Test")
class TelevisionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void addTelevision() throws Exception {

        String jsonInput = """
                {
                "name" : "LG",
                "price" : "400.00"
                }
                
           
                """;

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("addtv")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInput))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String createdId = result.getResponse().getContentAsString();
        assertThat(result.getResponse().getHeader("Location"), matchesPattern("^.*/televisions/" + createdId));

    }
}