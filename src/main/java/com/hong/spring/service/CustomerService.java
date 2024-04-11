package com.hong.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hong.spring.entity.Customer;
import com.hong.spring.repo.CustomerRepository;
import com.hong.spring.repo.CustomRepository;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerService {

	// @Autowired
	private final CustomerRepository repository;
	private final CustomRepository repository2;

	public CustomerService(CustomerRepository repository, CustomRepository repository2) {
        this.repository = repository;
		this.repository2 = repository2;
    }
	
	public void test() {

		// Save a new customer
		Customer newCustomer = new Customer();
		newCustomer.setFirstName("JohnH");
		newCustomer.setLastName("SmithH");
		repository.save(newCustomer);
		
		// Find a customer by ID
		// Optional<Customer> result = repository.findById(1L);
		// result.ifPresent(customer -> System.out.println(customer));
		
		// Find customers by last name
		// List<Customer> customers = repository.findByLastName("Smith");
		// customers.forEach(customer -> System.out.println(customer));
		
		// List all customers
		// Iterable<Customer> iterator = repository.findAll();
		// iterator.forEach(customer -> System.out.println(customer));

		List<Customer> iterator = repository2.getAll();
		iterator.forEach(customer -> System.out.println(customer));
		
		// Count number of customer
		long count = repository.count();
		System.out.println("Number of customers: " + count);

	}
}
