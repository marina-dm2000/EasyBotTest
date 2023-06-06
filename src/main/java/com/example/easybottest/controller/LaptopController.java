package com.example.easybottest.controller;

import com.example.easybottest.dto.laptop.LaptopRequestDTO;
import com.example.easybottest.dto.laptop.LaptopResponseDTO;
import com.example.easybottest.model.Laptop;
import com.example.easybottest.service.LaptopService;
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
@RequestMapping("/api/laptops")
@RequiredArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping
    public ResponseEntity<LaptopResponseDTO> createLaptop(
            @RequestBody LaptopRequestDTO laptopRequestDTO) {
        checkRequest(laptopRequestDTO);
        Laptop laptop = laptopService.createLaptop(laptopRequestDTO);
        LaptopResponseDTO responseDTO = convertToLaptopResponseDTO(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/{laptopId}")
    public ResponseEntity<LaptopResponseDTO> updateLaptop(
            @PathVariable Long laptopId,
            @RequestBody LaptopRequestDTO updateRequest) {
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
        List<Laptop> laptops = laptopService.findAll();
        List<LaptopResponseDTO> laptopResponseDTOs = laptops.stream()
                .map(LaptopController::convertToLaptopResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(laptopResponseDTOs);
    }

    private static LaptopResponseDTO convertToLaptopResponseDTO(Laptop laptop) {
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

    private static void checkRequest(LaptopRequestDTO laptopRequestDTO) {
        if (laptopRequestDTO.getPrice() == null
                || laptopRequestDTO.getCount() == null
                || laptopRequestDTO.getFabricator() == null
                || laptopRequestDTO.getSerialNumber() == null
                || laptopRequestDTO.getSize() == null)
            throw new IllegalArgumentException("one or more of fields is null");
    }
}
