package com.hong.spring.repo;

import java.util.List;
import com.hong.spring.entity.Customer;

public interface CustomRepository {
    // void delete(Customer entity);
    // Long exists(String name);
    // Customer get(Long identifier);
    List<Customer> getAll();
    // List<Customer> getByCount(int number);
    // Long save(Customer entity);
}
