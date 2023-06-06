package com.example.easybottest.controller;

import com.example.easybottest.dto.ScreenRequestDTO;
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
    public ResponseEntity<Screen> createScreen(
            @RequestBody ScreenRequestDTO screenRequestDTO) {
        checkRequest(screenRequestDTO);
        Screen screen = screenService.createScreen(screenRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(screen);
    }

    @PatchMapping("/{screenId}")
    public ResponseEntity<Screen> updateScreen(
            @PathVariable Long screenId,
            @RequestBody ScreenRequestDTO updateRequest) {
        Screen updatedScreen = screenService.updateScreen(screenId, updateRequest);
        return ResponseEntity.ok(updatedScreen);
    }

    @GetMapping("/{screenId}")
    public ResponseEntity<Screen> findScreenById(@PathVariable Long screenId) {
        Screen screen = screenService.getProductById(screenId);
        return ResponseEntity.ok(screen);
    }

    @GetMapping
    public ResponseEntity<List<Screen>> findAll() {
        List<Screen> screens = screenService.findAll();
        return ResponseEntity.ok(screens);
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
