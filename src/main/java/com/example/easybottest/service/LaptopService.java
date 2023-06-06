package com.example.easybottest.service;

import com.example.easybottest.dto.LaptopRequestDTO;
import com.example.easybottest.model.Laptop;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class LaptopService implements Service<Laptop> {
    private final ProductRepository<Laptop> laptopRepository;

    public Laptop createLaptop(
            LaptopRequestDTO laptopRequestDTO) {
        Laptop laptop = Laptop
                .builder()
                .serialNumber(laptopRequestDTO.getSerialNumber())
                .fabricator(laptopRequestDTO.getFabricator())
                .price(laptopRequestDTO.getPrice())
                .size(laptopRequestDTO.getSize())
                .count(laptopRequestDTO.getCount())
                .build();

        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(Long laptopId, LaptopRequestDTO updateRequest) {
        Laptop laptop = getProductById(laptopId);
        if (updateRequest.getFabricator() != null)
            laptop.setFabricator(updateRequest.getFabricator());
        if (updateRequest.getPrice() != null)
            laptop.setPrice(updateRequest.getPrice());
        if (updateRequest.getSize() != null)
            laptop.setSize(updateRequest.getSize());
        if (updateRequest.getCount() != null)
            laptop.setCount(updateRequest.getCount());
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop getProductById(Long productId) {
        return laptopRepository.findById(productId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Laptop not found with ID: " + productId));
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @Override
    public ProductType getProductType() {
        return ProductType.LAPTOP;
    }
}
