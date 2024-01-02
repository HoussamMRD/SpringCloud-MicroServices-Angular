package com.MRD.orderservice.Service;

import com.MRD.orderservice.Model.Customer;
import com.MRD.orderservice.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {

    @GetMapping("/products/{id}?projection=FullProduct")
    public Product ProductById(@PathVariable Long id);

    @GetMapping("/products?projection=FullProduct")
    public PagedModel<Product> AllProducts();


}
