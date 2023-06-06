package com.example.easybottest.repository;

import com.example.easybottest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T, Long> {
    @Query("SELECT p FROM Product p WHERE p.serialNumber = ?1")
    List<Product> findBySerialNumber(Long serialNumber);
}