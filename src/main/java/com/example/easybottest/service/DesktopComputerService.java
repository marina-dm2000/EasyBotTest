package com.example.easybottest.service;

import com.example.easybottest.dto.DesktopComputerDTO;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.repository.DesktopComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
            DesktopComputerDTO desktopRequestDTO) {
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

    /*public DesktopComputer getDesktopComputerById(Long desktopId) {
        return desktopComputerRepository.findById(desktopId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Desktop computer not found with ID: " + desktopId));
    }*/

    public DesktopComputer updateDesktop(Long desktopId, DesktopComputerDTO updateRequest) {
        DesktopComputer desktop = getProductById(desktopId);
        desktop.setFabricator(updateRequest.getFabricator());
        desktop.setPrice(updateRequest.getPrice());
        desktop.setFormFactor(updateRequest.getFormFactor());
        desktop.setCount(updateRequest.getCount());
        return desktopComputerRepository.save(desktop);
    }

    public List<DesktopComputer> findAll() {
        return desktopComputerRepository.findAll();
    }
}
