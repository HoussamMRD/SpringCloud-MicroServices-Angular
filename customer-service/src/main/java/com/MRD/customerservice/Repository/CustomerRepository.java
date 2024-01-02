package com.MRD.customerservice.Repository;

import com.MRD.customerservice.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
