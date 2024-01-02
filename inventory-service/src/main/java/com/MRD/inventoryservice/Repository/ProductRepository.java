package com.MRD.inventoryservice.Repository;

import com.MRD.inventoryservice.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
