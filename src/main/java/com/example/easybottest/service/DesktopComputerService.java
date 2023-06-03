package com.example.easybottest.service;

import com.example.easybottest.dto.desktopComputer.DesktopComputerRequestDTO;
import com.example.easybottest.dto.desktopComputer.DesktopComputerUpdateRequest;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.repository.DesktopComputerRepository;
import org.springframework.stereotype.Service;

@Service
public class DesktopComputerService extends ProductService<DesktopComputer, DesktopComputerRepository> {
    private final DesktopComputerRepository desktopComputerRepository;

    public DesktopComputerService(DesktopComputerRepository desktopComputerRepository) {
        super(desktopComputerRepository);
        this.desktopComputerRepository = desktopComputerRepository;
    }

    public DesktopComputer save(DesktopComputer desktopComputer) {
        return desktopComputerRepository.save(desktopComputer);
    }

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

    public DesktopComputer updateDesktop(Long desktopId, DesktopComputerUpdateRequest updateRequest) {
        DesktopComputer desktop = getProductById(desktopId);
        desktop.setFabricator(updateRequest.getFabricator());
        desktop.setPrice(updateRequest.getPrice());
        desktop.setFormFactor(updateRequest.getFormFactor());
        desktop.setCount(updateRequest.getCount());
        return desktopComputerRepository.save(desktop);
    }
}
