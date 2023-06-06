package com.example.easybottest.service;

import com.example.easybottest.dto.HardDiskRequestDTO;
import com.example.easybottest.model.HardDisk;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class HardDiskService implements Service<HardDisk> {

    private final ProductRepository<HardDisk> hardDiskRepository;

    public HardDisk createHardDisk(
            HardDiskRequestDTO hardDiskRequestDTO) {
        HardDisk hardDisk = HardDisk
                .builder()
                .serialNumber(hardDiskRequestDTO.getSerialNumber())
                .fabricator(hardDiskRequestDTO.getFabricator())
                .price(hardDiskRequestDTO.getPrice())
                .volume(hardDiskRequestDTO.getVolume())
                .count(hardDiskRequestDTO.getCount())
                .build();

        return hardDiskRepository.save(hardDisk);
    }

    public HardDisk updateHardDisk(Long hardDiskId, HardDiskRequestDTO updateRequest) {
        HardDisk hardDisk = getProductById(hardDiskId);
        if (updateRequest.getFabricator() != null)
            hardDisk.setFabricator(updateRequest.getFabricator());
        if (updateRequest.getPrice() != null)
            hardDisk.setPrice(updateRequest.getPrice());
        if (updateRequest.getVolume() != null)
            hardDisk.setVolume(updateRequest.getVolume());
        if (updateRequest.getCount() != null)
            hardDisk.setCount(updateRequest.getCount());
        return hardDiskRepository.save(hardDisk);
    }

    @Override
    public HardDisk getProductById(Long productId) {
        return hardDiskRepository.findById(productId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Hard disk not found with ID: " + productId));
    }

    @Override
    public List<HardDisk> findAll() {
        return hardDiskRepository.findAll();
    }

    @Override
    public ProductType getProductType() {
        return ProductType.HARD_DISK;
    }
}
