package com.MRD.orderservice.Entity;


import com.MRD.orderservice.Model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class ProductItem {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long productId;

        @Transient
        private Product product;

        private Double price;

        private Integer quantity;

        @ManyToOne
        @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
        private Order order;



}
