package com.example.easybottest.controller;

import com.example.easybottest.dto.LaptopRequestDTO;
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

@RestController
@RequestMapping("/api/laptops")
@RequiredArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping
    public ResponseEntity<Laptop> createLaptop(
            @RequestBody LaptopRequestDTO laptopRequestDTO) {
        checkRequest(laptopRequestDTO);
        Laptop laptop = laptopService.createLaptop(laptopRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(laptop);
    }

    @PatchMapping("/{laptopId}")
    public ResponseEntity<Laptop> updateLaptop(
            @PathVariable Long laptopId,
            @RequestBody LaptopRequestDTO updateRequest) {
        Laptop updatedLaptop = laptopService.updateLaptop(laptopId, updateRequest);
        return ResponseEntity.ok(updatedLaptop);
    }

    @GetMapping("/{laptopId}")
    public ResponseEntity<Laptop> findLaptopById(@PathVariable Long laptopId) {
        Laptop laptop = laptopService.getProductById(laptopId);
        return ResponseEntity.ok(laptop);
    }

    @GetMapping
    public ResponseEntity<List<Laptop>> findAll() {
        List<Laptop> laptops = laptopService.findAll();
        return ResponseEntity.ok(laptops);
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
