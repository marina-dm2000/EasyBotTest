package com.example.easybottest.service;

import com.example.easybottest.dto.hardDisk.HardDiskRequestDTO;
import com.example.easybottest.dto.hardDisk.HardDiskUpdateRequestDTO;
import com.example.easybottest.model.HardDisk;
import com.example.easybottest.repository.HardDiskRepository;
import org.springframework.stereotype.Service;

@Service
public class HardDiskService extends ProductService<HardDisk, HardDiskRepository> {

    private final HardDiskRepository hardDiskRepository;

    public HardDiskService(HardDiskRepository hardDiskRepository) {
        super(hardDiskRepository);
        this.hardDiskRepository = hardDiskRepository;
    }

    public HardDisk save(HardDisk hardDisk) {
        return hardDiskRepository.save(hardDisk);
    }

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

    public HardDisk updateHardDisk(Long hardDiskId, HardDiskUpdateRequestDTO updateRequest) {
        HardDisk hardDisk = getProductById(hardDiskId);
        hardDisk.setFabricator(updateRequest.getFabricator());
        hardDisk.setPrice(updateRequest.getPrice());
        hardDisk.setVolume(updateRequest.getVolume());
        hardDisk.setCount(updateRequest.getCount());
        return hardDiskRepository.save(hardDisk);
    }
}
