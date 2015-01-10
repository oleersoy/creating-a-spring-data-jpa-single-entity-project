package com.fireflysemantics.spring.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fireflysemantics.spring.domain.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);
}
