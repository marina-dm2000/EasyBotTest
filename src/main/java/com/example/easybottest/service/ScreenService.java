package com.example.easybottest.service;

import com.example.easybottest.dto.screen.ScreenRequestDTO;
import com.example.easybottest.dto.screen.ScreenUpdateRequestDTO;
import com.example.easybottest.model.Screen;
import com.example.easybottest.repository.ScreenRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService implements ProductService<Screen, ScreenRepository> {
    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public Screen save(Screen screen) {
        return screenRepository.save(screen);
    }

    public Screen createScreen(
            ScreenRequestDTO screenRequestDTO) {
        Screen screen = Screen
                .builder()
                .serialNumber(screenRequestDTO.getSerialNumber())
                .fabricator(screenRequestDTO.getFabricator())
                .price(screenRequestDTO.getPrice())
                .diagonal(screenRequestDTO.getDiagonal())
                .count(screenRequestDTO.getCount())
                .build();

        return screenRepository.save(screen);
    }

    public Screen updateScreen(Long screenId, ScreenUpdateRequestDTO updateRequest) {
        Screen screen = getProductById(screenId);
        screen.setFabricator(updateRequest.getFabricator());
        screen.setPrice(updateRequest.getPrice());
        screen.setDiagonal(updateRequest.getDiagonal());
        screen.setCount(updateRequest.getCount());
        return screenRepository.save(screen);
    }

    @Override
    public Screen getProductById(Long productId) {
        return screenRepository.findById(productId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Screen not found with ID: " + productId));
    }

    @Override
    public List<Screen> findAll() {
        return screenRepository.findAll();
    }
}
