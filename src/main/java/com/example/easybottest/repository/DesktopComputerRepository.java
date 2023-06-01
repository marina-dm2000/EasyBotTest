package com.example.easybottest.repository;

import com.example.easybottest.model.DesktopComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DesktopComputerRepository extends CrudRepository<DesktopComputer, Long> {
}