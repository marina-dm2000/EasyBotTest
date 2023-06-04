package com.example.easybottest.controller;

import com.example.easybottest.dto.desktopComputer.DesktopComputerRequestDTO;
import com.example.easybottest.dto.desktopComputer.DesktopComputerResponseDTO;
import com.example.easybottest.dto.desktopComputer.DesktopComputerUpdateRequestDTO;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.service.DesktopComputerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PatchMapping("/{desktopId}")
    public ResponseEntity<DesktopComputerResponseDTO> updateDesktop(
            @PathVariable Long desktopId,
            @Valid @RequestBody DesktopComputerUpdateRequestDTO updateRequest) {
        DesktopComputer updatedDesktop = desktopComputerService.updateDesktop(desktopId, updateRequest);
        DesktopComputerResponseDTO desktopResponseDTO = convertToDesktopResponseDTO(updatedDesktop);
        return ResponseEntity.ok(desktopResponseDTO);
    }

    @GetMapping("/{desktopId}")
    public ResponseEntity<DesktopComputerResponseDTO> findDesktopById(@PathVariable Long desktopId) {
        DesktopComputer desktop = desktopComputerService.getProductById(desktopId);
        DesktopComputerResponseDTO desktopResponseDTO = convertToDesktopResponseDTO(desktop);
        return ResponseEntity.ok(desktopResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<DesktopComputerResponseDTO>> findAll() {
        List<DesktopComputer> desktopComputers = desktopComputerService.findAllProduct();
        List<DesktopComputerResponseDTO> desktopComputerResponseDTOs = desktopComputers.stream()
                .map(this::convertToDesktopResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(desktopComputerResponseDTOs);
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
