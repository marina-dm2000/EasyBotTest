package com.example.easybottest.controller;

import com.example.easybottest.dto.laptop.LaptopRequestDTO;
import com.example.easybottest.dto.laptop.LaptopResponseDTO;
import com.example.easybottest.dto.laptop.LaptopUpdateRequestDTO;
import com.example.easybottest.model.Laptop;
import com.example.easybottest.service.LaptopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public ResponseEntity<LaptopResponseDTO> createLaptop(
            @Valid @RequestBody LaptopRequestDTO laptopRequestDTO) {
        Laptop laptop = laptopService.createLaptop(laptopRequestDTO);
        LaptopResponseDTO responseDTO = convertToLaptopResponseDTO(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/{laptopId}")
    public ResponseEntity<LaptopResponseDTO> updateLaptop(
            @PathVariable Long laptopId,
            @Valid @RequestBody LaptopUpdateRequestDTO updateRequest) {
        Laptop updatedLaptop = laptopService.updateLaptop(laptopId, updateRequest);
        LaptopResponseDTO laptopResponseDTO = convertToLaptopResponseDTO(updatedLaptop);
        return ResponseEntity.ok(laptopResponseDTO);
    }

    @GetMapping("/{laptopId}")
    public ResponseEntity<LaptopResponseDTO> findLaptopById(@PathVariable Long laptopId) {
        Laptop laptop = laptopService.getProductById(laptopId);
        LaptopResponseDTO laptopResponseDTO = convertToLaptopResponseDTO(laptop);
        return ResponseEntity.ok(laptopResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LaptopResponseDTO>> findAll() {
        List<Laptop> laptops = laptopService.findAllProduct();
        List<LaptopResponseDTO> laptopResponseDTOs = laptops.stream()
                .map(this::convertToLaptopResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(laptopResponseDTOs);
    }

    private LaptopResponseDTO convertToLaptopResponseDTO(Laptop laptop) {
        return LaptopResponseDTO.
                builder()
                .id(laptop.getId())
                .serialNumber(laptop.getSerialNumber())
                .fabricator(laptop.getFabricator())
                .price(laptop.getPrice())
                .size(laptop.getSize())
                .count(laptop.getCount())
                .build();
    }
}
