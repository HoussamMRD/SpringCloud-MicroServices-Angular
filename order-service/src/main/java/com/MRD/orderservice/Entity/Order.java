package com.MRD.orderservice.Entity;

import com.MRD.orderservice.Model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity  @Table(name = "orders")
@Data  @NoArgsConstructor   @AllArgsConstructor  @Builder


public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;

    private OrderStatus status;

    private Long customerId;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ProductItem> ProductItems;
}
