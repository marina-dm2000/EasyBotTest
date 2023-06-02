package com.example.easybottest.repository;

import com.example.easybottest.model.Product;
import com.example.easybottest.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface ProductRepository<T extends Product> extends JpaRepository<T, Long> {
}