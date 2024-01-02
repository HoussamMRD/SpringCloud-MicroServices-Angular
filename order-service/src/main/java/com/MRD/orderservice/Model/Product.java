package com.MRD.orderservice.Model;


import lombok.Data;

@Data

public class Product {

    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private int quantity;

}
