package com.example.easybottest.controller;

import com.example.easybottest.dto.screen.ScreenRequestDTO;
import com.example.easybottest.dto.screen.ScreenResponseDTO;
import com.example.easybottest.model.Screen;
import com.example.easybottest.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<ScreenResponseDTO> createScreen(
            @RequestBody ScreenRequestDTO screenRequestDTO) {
        checkRequest(screenRequestDTO);
        Screen screen = screenService.createScreen(screenRequestDTO);
        ScreenResponseDTO responseDTO = convertToScreenResponseDTO(screen);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/{screenId}")
    public ResponseEntity<ScreenResponseDTO> updateScreen(
            @PathVariable Long screenId,
            @RequestBody ScreenRequestDTO updateRequest) {
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
        List<Screen> screens = screenService.findAll();
        List<ScreenResponseDTO> screenResponseDTOs = screens.stream()
                .map(ScreenController::convertToScreenResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(screenResponseDTOs);
    }

    private static ScreenResponseDTO convertToScreenResponseDTO(Screen screen) {
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

    private static void checkRequest(ScreenRequestDTO screenRequestDTO) {
        if (screenRequestDTO.getPrice() == null
                || screenRequestDTO.getCount() == null
                || screenRequestDTO.getFabricator() == null
                || screenRequestDTO.getSerialNumber() == null
                || screenRequestDTO.getDiagonal() == null)
            throw new IllegalArgumentException("one or more of fields is null");
    }
}
