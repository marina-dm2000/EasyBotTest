package com.example.easybottest.controller;

import com.example.easybottest.dto.desktopComputer.DesktopComputerRequestDTO;
import com.example.easybottest.dto.desktopComputer.DesktopComputerResponseDTO;
import com.example.easybottest.dto.desktopComputer.DesktopComputerUpdateRequest;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.service.DesktopComputerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/desktops")
public class DesktopComputerController {
    private final DesktopComputerService desktopComputerService;

    public DesktopComputerController(DesktopComputerService desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @PostMapping
    public ResponseEntity<DesktopComputerResponseDTO> createDesktopComputer(
            @Valid @RequestBody DesktopComputerRequestDTO desktopComputerRequestDTO) {
        DesktopComputer desktopComputer = desktopComputerService.createDesktopComputer(desktopComputerRequestDTO);
        DesktopComputerResponseDTO responseDTO = convertToDesktopResponseDTO(desktopComputer);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{desktopId}")
    public ResponseEntity<DesktopComputerResponseDTO> updateDesktop(
            @PathVariable Long desktopId,
            @Valid @RequestBody DesktopComputerUpdateRequest updateRequest) {
        DesktopComputer updatedDesktop = desktopComputerService.updateDesktop(desktopId, updateRequest);
        DesktopComputerResponseDTO postResponseDTO = convertToDesktopResponseDTO(updatedDesktop);
        return ResponseEntity.ok(postResponseDTO);
    }

    @GetMapping("/{desktopId}")
    public ResponseEntity<DesktopComputerResponseDTO> getPostById(@PathVariable Long desktopId) {
        DesktopComputer desktop = desktopComputerService.getProductById(desktopId);
        DesktopComputerResponseDTO desktopResponseDTO = convertToDesktopResponseDTO(desktop);
        return ResponseEntity.ok(desktopResponseDTO);
    }

    private DesktopComputerResponseDTO convertToDesktopResponseDTO(DesktopComputer desktopComputer) {
        return DesktopComputerResponseDTO.
                builder()
                .id(desktopComputer.getId())
                .serialNumber(desktopComputer.getSerialNumber())
                .fabricator(desktopComputer.getFabricator())
                .price(desktopComputer.getPrice())
                .formFactor(desktopComputer.getFormFactor())
                .count(desktopComputer.getCount())
                .build();
    }
}
