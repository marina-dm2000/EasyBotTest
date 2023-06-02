package com.example.easybottest.service;

import com.example.easybottest.dto.desktopComputer.DesktopComputerRequestDTO;
import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.repository.DesktopComputerRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DesktopComputerService {
    private final DesktopComputerRepository desktopComputerRepository;

    public DesktopComputerService(DesktopComputerRepository desktopComputerRepository) {
        this.desktopComputerRepository = desktopComputerRepository;
    }

    public DesktopComputer save(DesktopComputer desktopComputer) {
        return desktopComputerRepository.save(desktopComputer);
    }

    public void delete(DesktopComputer desktopComputer) {
        desktopComputerRepository.delete(desktopComputer);
    }

    public List<DesktopComputer> findAll() {
        return desktopComputerRepository.findAll();
    }

    public DesktopComputer createDesktopComputer(
            DesktopComputerRequestDTO desktopRequestDTO, Long userId) {
        DesktopComputer desktop = new DesktopComputer();
        desktop.setSerialNumber(desktopRequestDTO.getSerialNumber());
        desktop.setFabricator(desktopRequestDTO.getFabricator());
        desktop.setPrice(desktopRequestDTO.getPrice());
        desktop.setFormFactor(desktopRequestDTO.getFormFactor());
        return desktopComputerRepository.save(desktop);
    }

    public DesktopComputer getDesktopComputerById(Long desktopId) {
        return desktopComputerRepository.findById(desktopId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Desktop computer not found with ID: " + desktopId));
    }

    public void deleteDesktopComputer(Long desktopId) {
        DesktopComputer desktopComputer = getDesktopComputerById(desktopId);
        desktopComputerRepository.delete(desktopComputer);
    }
}
