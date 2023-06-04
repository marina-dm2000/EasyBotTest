package com.example.easybottest.controller;

import com.example.easybottest.dto.screen.ScreenRequestDTO;
import com.example.easybottest.dto.screen.ScreenResponseDTO;
import com.example.easybottest.dto.screen.ScreenUpdateRequestDTO;
import com.example.easybottest.model.Screen;
import com.example.easybottest.service.ScreenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {
    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public ResponseEntity<ScreenResponseDTO> createScreen(
            @Valid @RequestBody ScreenRequestDTO screenRequestDTO) {
        Screen screen = screenService.createScreen(screenRequestDTO);
        ScreenResponseDTO responseDTO = convertToScreenResponseDTO(screen);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/{screenId}")
    public ResponseEntity<ScreenResponseDTO> updateScreen(
            @PathVariable Long screenId,
            @Valid @RequestBody ScreenUpdateRequestDTO updateRequest) {
        Screen updatedScreen = screenService.updateScreen(screenId, updateRequest);
        ScreenResponseDTO screenResponseDTO = convertToScreenResponseDTO(updatedScreen);
        return ResponseEntity.ok(screenResponseDTO);
    }

    @GetMapping("/{screenId}")
    public ResponseEntity<ScreenResponseDTO> findScreenById(@PathVariable Long screenId) {
        Screen screen = screenService.getProductById(screenId);
        ScreenResponseDTO screenResponseDTO = convertToScreenResponseDTO(screen);
        return ResponseEntity.ok(screenResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ScreenResponseDTO>> findAll() {
        List<Screen> screens = screenService.findAllProduct();
        List<ScreenResponseDTO> screenResponseDTOs = screens.stream()
                .map(this::convertToScreenResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(screenResponseDTOs);
    }

    private ScreenResponseDTO convertToScreenResponseDTO(Screen screen) {
        return ScreenResponseDTO.
                builder()
                .id(screen.getId())
                .serialNumber(screen.getSerialNumber())
                .fabricator(screen.getFabricator())
                .price(screen.getPrice())
                .diagonal(screen.getDiagonal())
                .count(screen.getCount())
                .build();
    }
}
