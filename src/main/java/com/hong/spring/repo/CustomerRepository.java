package com.hong.spring.repo;

import java.util.List;
import com.hong.spring.entity.Customer;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
