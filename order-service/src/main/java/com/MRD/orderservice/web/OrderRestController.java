package com.MRD.orderservice.web;


import com.MRD.orderservice.Entity.Order;
import com.MRD.orderservice.Model.Customer;
import com.MRD.orderservice.Model.Product;
import com.MRD.orderservice.Repository.OrderRepository;
import com.MRD.orderservice.Repository.ProductItemRepository;
import com.MRD.orderservice.Service.CustomerRestClientService;
import com.MRD.orderservice.Service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClientService.CustomerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.ProductById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
