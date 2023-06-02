package com.example.easybottest.controller;

import com.example.easybottest.service.DesktopComputerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/desktops")
public class DesktopComputerController {
    private final DesktopComputerService desktopComputerService;

    public DesktopComputerController(DesktopComputerService desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @DeleteMapping("/{desktopId}")
    public ResponseEntity<?> deleteDesktopComputer(@PathVariable Long desktopId) {
        desktopComputerService.deleteDesktopComputer(desktopId);
        return ResponseEntity.ok().build();
    }
}
