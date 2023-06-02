package com.example.easybottest.repository;

import com.example.easybottest.model.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {
}