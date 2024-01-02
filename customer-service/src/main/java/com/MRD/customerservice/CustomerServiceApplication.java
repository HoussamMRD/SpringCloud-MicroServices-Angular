package com.MRD.customerservice;

import com.MRD.customerservice.Entity.Customer;
import com.MRD.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("Houssam").email("hsm@gmail.com").build(),
					Customer.builder().name("MRD").email("mrd@gmail.com").build(),
					Customer.builder().name("Aymen").email("aymn@gmail.com").build(),
					Customer.builder().name("Mohamed").email("mo@gmail.com").build(),
					Customer.builder().name("karim").email("karim@gmail.com").build()

			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
