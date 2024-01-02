package com.MRD.inventoryservice;

import com.MRD.inventoryservice.Entity.Product;
import com.MRD.inventoryservice.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder().name("Dell XPS 13").category("laptop").description(" i7 ram ddr4 32G").price(1500.0).quantity(10).build(),
					Product.builder().name("Lenovo").category("laptop").description("i5 8th ram ddr4 32G ").price(2000.0).quantity(15).build(),
					Product.builder().name("HP").category("laptop").description("i9 ram ddr4 32G  ").price(1000.0).quantity(20).build(),
					Product.builder().name("MacBook").category("laptop").description("i7 ram ddr4 32G ").price(2500.0).quantity(25).build(),
					Product.builder().name("iphone 15").category("smartPhones").description(" ram  32G ").price(15000.0).quantity(30).build(),
					Product.builder().name("S23 ultra").category("smartPhones").description(" ram  32G ").price(10000.0).quantity(35).build()
			));
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
