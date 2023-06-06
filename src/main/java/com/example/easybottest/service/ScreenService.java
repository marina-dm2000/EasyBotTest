package com.example.easybottest.service;

import com.example.easybottest.dto.ScreenRequestDTO;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.model.Screen;
import com.example.easybottest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ScreenService implements Service<Screen> {
    private final ProductRepository<Screen> screenRepository;

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

    public Screen updateScreen(Long screenId, ScreenRequestDTO updateRequest) {
        Screen screen = getProductById(screenId);
        if (updateRequest.getFabricator() != null)
            screen.setFabricator(updateRequest.getFabricator());
        if (updateRequest.getPrice() != null)
            screen.setPrice(updateRequest.getPrice());
        if (updateRequest.getDiagonal() != null)
            screen.setDiagonal(updateRequest.getDiagonal());
        if (updateRequest.getCount() != null)
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

    @Override
    public ProductType getProductType() {
        return ProductType.SCREEN;
    }
}
