package com.example.easybottest.service;

import com.example.easybottest.dto.desktopComputer.DesktopComputerRequestDTO;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.model.ProductType;
import com.example.easybottest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesktopComputerService implements SomeService<DesktopComputer> {
    private final ProductRepository<DesktopComputer> desktopComputerRepository;

    public DesktopComputer createDesktopComputer(
            DesktopComputerRequestDTO desktopRequestDTO) {
        DesktopComputer desktop = DesktopComputer
                .builder()
                .serialNumber(desktopRequestDTO.getSerialNumber())
                .fabricator(desktopRequestDTO.getFabricator())
                .price(desktopRequestDTO.getPrice())
                .formFactor(desktopRequestDTO.getFormFactor())
                .count(desktopRequestDTO.getCount())
                .build();

        return desktopComputerRepository.save(desktop);
    }

    public DesktopComputer updateDesktop(Long desktopId, DesktopComputerRequestDTO updateRequest) {
        DesktopComputer desktop = getProductById(desktopId);
        if (updateRequest.getFabricator() != null)
            desktop.setFabricator(updateRequest.getFabricator());
        if (updateRequest.getPrice() != null)
            desktop.setPrice(updateRequest.getPrice());
        if (updateRequest.getFormFactor() != null)
            desktop.setFormFactor(updateRequest.getFormFactor());
        if (updateRequest.getCount() != null)
            desktop.setCount(updateRequest.getCount());
        return desktopComputerRepository.save(desktop);
    }

    @Override
    public DesktopComputer getProductById(Long productId) {
        return desktopComputerRepository.findById(productId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Desktop computer not found with ID: " + productId));
    }

    @Override
    public List<DesktopComputer> findAll() {
        return desktopComputerRepository.findAll();
    }

    @Override
    public ProductType getProductType() {
        return ProductType.DESKTOP_COMPUTER;
    }
}
