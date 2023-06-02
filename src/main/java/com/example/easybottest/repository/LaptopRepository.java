package com.example.easybottest.repository;

import com.example.easybottest.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}