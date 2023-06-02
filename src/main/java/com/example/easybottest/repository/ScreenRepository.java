package com.example.easybottest.repository;

import com.example.easybottest.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}