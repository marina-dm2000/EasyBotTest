package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "screen")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "serial-number", nullable = false)
    private Long serialNumber;

    @Column(name = "fabricator", nullable = false)
    private String fabricator;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "count", nullable = false)
    private static int count;

    @Column(name = "diagonal", nullable = false)
    private int diagonal;

}