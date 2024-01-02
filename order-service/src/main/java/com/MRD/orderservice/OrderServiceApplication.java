package com.MRD.orderservice;

import com.MRD.orderservice.Entity.Order;
import com.MRD.orderservice.Entity.OrderStatus;
import com.MRD.orderservice.Entity.ProductItem;
import com.MRD.orderservice.Model.Customer;
import com.MRD.orderservice.Model.Product;
import com.MRD.orderservice.Repository.OrderRepository;
import com.MRD.orderservice.Repository.ProductItemRepository;
import com.MRD.orderservice.Service.CustomerRestClientService;
import com.MRD.orderservice.Service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository ,
							ProductItemRepository productItemRepository,
							CustomerRestClientService customerRestClientService ,
							InventoryRestClientService inventoryRestClientService) {
		return args -> {
			List<Customer> customers = customerRestClientService.AllCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.AllProducts().getContent().stream().toList();
			Long customerId = 1L;
			Random random = new Random();
			Customer customer = customerRestClientService.CustomerById(customerId);
			for (int i =0 ;i <20; i++ ){
				Order order = Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random() > 0.5 ? OrderStatus.CREATED : OrderStatus.CANCELLED)
						.createdAt(new Date())
						.build();
				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j < products.size() ; j++) {
					if(Math.random()>0.70){
						ProductItem productItem=ProductItem.builder()
								.order(savedOrder)
								.productId(products.get(j).getId())
								.price(products.get(j).getPrice())
								.quantity(1+random.nextInt(10))
								.build();
						productItemRepository.save(productItem);


					}

				}
			}
		};
	}

}