package com.example.easybottest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hard-disk")
public class HardDisk {
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
    private int count;

    @Column(name = "volume", nullable = false)
    private int volume;

}