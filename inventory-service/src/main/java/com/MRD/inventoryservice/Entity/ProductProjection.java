package com.MRD.inventoryservice.Entity;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "FullProduct", types = Product.class)

public interface ProductProjection {

    public Long getId();
    public String getName();
    public String getCategory();
    public String getDescription();
    public Double getPrice();
    public int getQuantity();
}
