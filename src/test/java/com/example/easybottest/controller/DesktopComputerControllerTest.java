package com.example.easybottest.controller;

import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.service.DesktopComputerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DesktopComputerController.class)
public class DesktopComputerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DesktopComputerService desktopComputerService;

    @Test
    public void testCreateDesktopComputer() throws Exception {
        mockMvc.perform(post("/api/desktops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"serialNumber\": 7857575," +
                                " \"fabricator\": \"Russia\", " +
                                "\"price\": 46.5," +
                                "\"formFactor\": \"DESKTOP\"," +
                                "\"count\": 5}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindDesktopById() throws Exception {
        mockMvc.perform(get("/api/desktops/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateDesktop() throws Exception {
        mockMvc.perform(patch("/api/desktops/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fabricator\": \"Germany\"}"))
                .andExpect(status().isOk());
    }
}
