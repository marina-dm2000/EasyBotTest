package com.example.easybottest.controller;

import com.example.easybottest.dto.HardDiskRequestDTO;
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
    public ResponseEntity<HardDisk> createHardDisk(
            @RequestBody HardDiskRequestDTO hardDiskRequestDTO) {
        checkRequest(hardDiskRequestDTO);
        HardDisk hardDisk = hardDiskService.createHardDisk(hardDiskRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(hardDisk);
    }

    @PatchMapping("/{hardDiskId}")
    public ResponseEntity<HardDisk> updateHardDisk(
            @PathVariable Long hardDiskId,
            @RequestBody HardDiskRequestDTO updateRequest) {
        HardDisk updatedHardDisk = hardDiskService.updateHardDisk(hardDiskId, updateRequest);
        return ResponseEntity.ok(updatedHardDisk);
    }

    @GetMapping("/{hardDiskId}")
    public ResponseEntity<HardDisk> findHardDiskById(@PathVariable Long hardDiskId) {
        HardDisk hardDisk = hardDiskService.getProductById(hardDiskId);
        return ResponseEntity.ok(hardDisk);
    }

    @GetMapping
    public ResponseEntity<List<HardDisk>> findAll() {
        List<HardDisk> hardDisks = hardDiskService.findAll();
        return ResponseEntity.ok(hardDisks);
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
