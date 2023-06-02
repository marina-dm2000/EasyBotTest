package com.example.easybottest.repository;

import com.example.easybottest.model.DesktopComputer;
import com.example.easybottest.model.FormFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DesktopComputerRepository extends ProductRepository<DesktopComputer> {
}