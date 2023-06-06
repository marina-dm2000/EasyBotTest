package com.example.easybottest.controller;

import com.example.easybottest.dto.DesktopComputerRequestDTO;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.service.DesktopComputerService;
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
@RequestMapping("/api/desktops")
@RequiredArgsConstructor
public class DesktopComputerController {
    private final DesktopComputerService desktopComputerService;

    @PostMapping
    public ResponseEntity<DesktopComputer> createDesktopComputer(
            @RequestBody DesktopComputerRequestDTO desktopComputerRequestDTO) {
        checkRequest(desktopComputerRequestDTO);
        DesktopComputer desktopComputer = desktopComputerService.createDesktopComputer(desktopComputerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(desktopComputer);
    }

    @PatchMapping("/{desktopId}")
    public ResponseEntity<DesktopComputer> updateDesktop(
            @PathVariable Long desktopId,
            @RequestBody DesktopComputerRequestDTO updateRequest) {
        DesktopComputer updatedDesktop = desktopComputerService.updateDesktop(desktopId, updateRequest);
        return ResponseEntity.ok(updatedDesktop);
    }

    @GetMapping("/{desktopId}")
    public ResponseEntity<DesktopComputer> findDesktopById(@PathVariable Long desktopId) {
        DesktopComputer desktop = desktopComputerService.getProductById(desktopId);
        return ResponseEntity.ok(desktop);
    }

    @GetMapping
    public ResponseEntity<List<DesktopComputer>> findAll() {
        List<DesktopComputer> desktopComputers = desktopComputerService.findAll();
        return ResponseEntity.ok(desktopComputers);
    }

    private static void checkRequest(DesktopComputerRequestDTO desktopComputerRequestDTO) {
        if (desktopComputerRequestDTO.getPrice() == null
                || desktopComputerRequestDTO.getCount() == null
                || desktopComputerRequestDTO.getFabricator() == null
                || desktopComputerRequestDTO.getSerialNumber() == null
                || desktopComputerRequestDTO.getFormFactor() == null)
            throw new IllegalArgumentException("one or more of fields is null");
    }
}
