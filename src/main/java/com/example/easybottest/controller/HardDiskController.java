package com.example.easybottest.controller;

import com.example.easybottest.dto.hardDisk.HardDiskRequestDTO;
import com.example.easybottest.dto.hardDisk.HardDiskResponseDTO;
import com.example.easybottest.model.HardDisk;
import com.example.easybottest.service.HardDiskService;
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
@RequestMapping("/api/hardDisks")
@RequiredArgsConstructor
public class HardDiskController {
    private final HardDiskService hardDiskService;

    @PostMapping
    public ResponseEntity<HardDiskResponseDTO> createHardDisk(
            @RequestBody HardDiskRequestDTO hardDiskRequestDTO) {
        checkRequest(hardDiskRequestDTO);
        HardDisk hardDisk = hardDiskService.createHardDisk(hardDiskRequestDTO);
        HardDiskResponseDTO responseDTO = convertToHardDiskResponseDTO(hardDisk);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/{hardDiskId}")
    public ResponseEntity<HardDiskResponseDTO> updateHardDisk(
            @PathVariable Long hardDiskId,
            @RequestBody HardDiskRequestDTO updateRequest) {
        HardDisk updatedHardDisk = hardDiskService.updateHardDisk(hardDiskId, updateRequest);
        HardDiskResponseDTO hardDiskResponseDTO = convertToHardDiskResponseDTO(updatedHardDisk);
        return ResponseEntity.ok(hardDiskResponseDTO);
    }

    @GetMapping("/{hardDiskId}")
    public ResponseEntity<HardDiskResponseDTO> findHardDiskById(@PathVariable Long hardDiskId) {
        HardDisk hardDisk = hardDiskService.getProductById(hardDiskId);
        HardDiskResponseDTO hardDiskResponseDTO = convertToHardDiskResponseDTO(hardDisk);
        return ResponseEntity.ok(hardDiskResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<HardDiskResponseDTO>> findAll() {
        List<HardDisk> hardDisks = hardDiskService.findAll();
        List<HardDiskResponseDTO> hardDiskResponseDTOs = hardDisks.stream()
                .map(HardDiskController::convertToHardDiskResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(hardDiskResponseDTOs);
    }

    private static HardDiskResponseDTO convertToHardDiskResponseDTO(HardDisk hardDisk) {
        return HardDiskResponseDTO.
                builder()
                .id(hardDisk.getId())
                .serialNumber(hardDisk.getSerialNumber())
                .fabricator(hardDisk.getFabricator())
                .price(hardDisk.getPrice())
                .volume(hardDisk.getVolume())
                .count(hardDisk.getCount())
                .build();
    }

    private static void checkRequest(HardDiskRequestDTO hardDiskRequestDTO) {
        if (hardDiskRequestDTO.getPrice() == null
                || hardDiskRequestDTO.getCount() == null
                || hardDiskRequestDTO.getFabricator() == null
                || hardDiskRequestDTO.getSerialNumber() == null
                || hardDiskRequestDTO.getVolume() == null)
            throw new IllegalArgumentException("one or more of fields is null");
    }
}
