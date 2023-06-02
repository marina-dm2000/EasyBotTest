package com.example.easybottest.repository;

import com.example.easybottest.model.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {
}