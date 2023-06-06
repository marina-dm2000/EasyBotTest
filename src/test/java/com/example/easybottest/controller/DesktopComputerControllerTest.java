package com.example.easybottest.controller;

import com.example.easybottest.dto.desktopComputer.DesktopComputerRequestDTO;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.model.FormFactor;
import com.example.easybottest.service.DesktopComputerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DesktopComputerController.class)
public class DesktopComputerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DesktopComputerService desktopComputerService;

    @Test
    public void testCreateDesktopComputer() throws Exception {
        DesktopComputer desktopComputer = desktopComputerService.createDesktopComputer(
                DesktopComputerRequestDTO
                        .builder()
                        .serialNumber(7474646L)
                        .fabricator("Russia")
                        .price(67)
                        .formFactor(FormFactor.MONOBLOCK)
                        .count(5).build());

        given(desktopComputer).willReturn(desktopComputer);
        mockMvc.perform(post("/api/desktops")
                .contentType(MediaType.APPLICATION_JSON))
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
