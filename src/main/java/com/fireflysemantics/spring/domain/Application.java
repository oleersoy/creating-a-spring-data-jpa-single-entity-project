package com.fireflysemantics.spring.domain;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.fireflysemantics.spring.domain.model.Customer;
import com.fireflysemantics.spring.domain.repository.CustomerRepository;

@Configuration
@EnableAutoConfiguration
public class Application {

  public static void main(String[] args) {

    ConfigurableApplicationContext context = SpringApplication.run(Application.class);
    CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

    // Persist customers
    customerRepository.save(new Customer("Dora", "dora@gmail.com"));
    customerRepository.save(new Customer("Diego", "diego@gmail.com"));
    customerRepository.save(new Customer("Boots", "boots@gmail.com"));
    customerRepository.save(new Customer("Swiper", "swiper@gmail.com"));
    customerRepository.save(new Customer("Tico", "tico@gmail.com"));

    // Retrieve customer assigned id 1L
    Customer customerByID = customerRepository.findOne(1L);

    System.out.println("Result of retrieving customer with using CustomerRepository.findOne(1L):");
    System.out.println("======================================================");
    System.out.println(customerByID);
    System.out.println("======================================================");

    // Retrieve all persisted customers
    Iterable<Customer> allCustomers = customerRepository.findAll();
    System.out.println("Customers retrieved with CustomerRepository.findAll():");
    System.out.println("======================================================");
    for (Customer customer : allCustomers) {
      System.out.println(customer);
    }
    System.out.println("======================================================");

    // Retrieve customers by name
    List<Customer> customers = customerRepository.findByName("Tico");
    System.out.println("Find Tico using CustomerRepository.findByName('Tico'):");
    System.out.println("======================================================");
    for (Customer customer : customers) {
      System.out.println(customer);
    }
    System.out.println("======================================================");
    
    System.out.println("Find Swiper with CustomerRepository.findByName('Swiper')");
    System.out.println("======================================================");
    Customer swiper = customerRepository.findByName("Swiper").get(0);
    System.out.println(swiper);
    System.out.println("======================================================");
    
    System.out.println("Update Swiper's email address with swiper.setEmail('swiper@yahoo.com')");
    swiper.setEmail("swiper@yahoo.com");
    System.out.println("Update Swiper using CustomerRepository.save(swiper'):");
    customerRepository.save(swiper);
    System.out.println("Find swiper again using CustomerRepository.findByName('Swiper'))");
    System.out.println("Swiper has a new email address.");
    System.out.println("======================================================");
    swiper = customerRepository.findByName("Swiper").get(0);
    System.out.println(swiper);
    System.out.println("======================================================");

    // Retrieve all persisted customers
    allCustomers = customerRepository.findAll();
    System.out.println("Customers retrieved with CustomerRepository.findAll()");
    System.out.println("Note that Swiper's email address is updated.");
    System.out.println("======================================================");
    for (Customer customer : allCustomers) {
      System.out.println(customer);
    }
    System.out.println("======================================================");

    System.out.println("Delete Swiper with CustomerRepository.delete(swiper):");
    System.out.println("======================================================");
    customerRepository.delete(swiper);
    System.out.println(swiper);
    System.out.println("======================================================");
   
    // Retrieve all persisted customers
    allCustomers = customerRepository.findAll();
    System.out.println("Customers retrieved with CustomerRepository.findAll()");
    System.out.println("Note that Swiper is missing.");
    System.out.println("======================================================");
    for (Customer customer : allCustomers) {
      System.out.println(customer);
    }
    System.out.println("======================================================");

    context.close();
  }
}