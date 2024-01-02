package com.MRD.inventoryservice.web;

import com.MRD.inventoryservice.Entity.Product;
import com.MRD.inventoryservice.Repository.ProductRepository;
import com.MRD.inventoryservice.exception.RessourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductRestController {


    @Autowired
    private ProductRepository productRepository;




    //build delete product REST API
@DeleteMapping("/Deleteproducts/{id}")
public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Long id){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new RessourceNotFound("Product not exist with id:"+id));
        productRepository.delete(product);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



























}
