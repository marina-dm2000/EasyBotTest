package com.example.easybottest.controller;

import com.example.easybottest.dto.DesktopComputerDTO;
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
    public ResponseEntity<DesktopComputerDTO> createDesktopComputer(
            @Valid @RequestBody DesktopComputerDTO desktopComputerRequestDTO) {
        DesktopComputer desktopComputer = desktopComputerService.createDesktopComputer(desktopComputerRequestDTO);
        DesktopComputerDTO responseDTO = convertToDesktopResponseDTO(desktopComputer);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{desktopId}")
    public ResponseEntity<DesktopComputerDTO> updateDesktop(
            @PathVariable Long desktopId,
            @Valid @RequestBody DesktopComputerDTO updateRequest) {
        DesktopComputer updatedDesktop = desktopComputerService.updateDesktop(desktopId, updateRequest);
        DesktopComputerDTO desktopResponseDTO = convertToDesktopResponseDTO(updatedDesktop);
        return ResponseEntity.ok(desktopResponseDTO);
    }

    @GetMapping("/{desktopId}")
    public ResponseEntity<DesktopComputerDTO> findDesktopById(@PathVariable Long desktopId) {
        DesktopComputer desktop = desktopComputerService.getProductById(desktopId);
        DesktopComputerDTO desktopResponseDTO = convertToDesktopResponseDTO(desktop);
        return ResponseEntity.ok(desktopResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<DesktopComputerDTO>> findAll() {
        List<DesktopComputer> desktopComputers = desktopComputerService.findAll();
        List<DesktopComputerDTO> commentResponseDTOs = desktopComputers.stream()
                .map(this::convertToDesktopResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(commentResponseDTOs);
    }

    private DesktopComputerDTO convertToDesktopResponseDTO(DesktopComputer desktopComputer) {
        return DesktopComputerDTO.
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
