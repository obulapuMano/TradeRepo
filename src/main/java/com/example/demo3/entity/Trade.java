package com.example.demo3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = " trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantity;
    private Double price;
    private  String currency;
    private String buySell;
    private String assetType;
    private String originCountry;
}
