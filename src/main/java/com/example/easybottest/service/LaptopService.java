package com.example.easybottest.service;

import com.example.easybottest.dto.laptop.LaptopRequestDTO;
import com.example.easybottest.dto.laptop.LaptopUpdateRequestDTO;
import com.example.easybottest.model.Laptop;
import com.example.easybottest.repository.LaptopRepository;
import org.springframework.stereotype.Service;

@Service
public class LaptopService extends ProductService<Laptop, LaptopRepository> {
    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        super(laptopRepository);
        this.laptopRepository = laptopRepository;
    }

    public Laptop save(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

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

    public Laptop updateLaptop(Long laptopId, LaptopUpdateRequestDTO updateRequest) {
        Laptop laptop = getProductById(laptopId);
        laptop.setFabricator(updateRequest.getFabricator());
        laptop.setPrice(updateRequest.getPrice());
        laptop.setSize(updateRequest.getSize());
        laptop.setCount(updateRequest.getCount());
        return laptopRepository.save(laptop);
    }
}
