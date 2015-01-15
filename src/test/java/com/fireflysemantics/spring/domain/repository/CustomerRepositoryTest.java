package com.fireflysemantics.spring.domain.repository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fireflysemantics.spring.domain.Application;
import com.fireflysemantics.spring.domain.model.Customer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.allOf;;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTest
{
	@Autowired
	CustomerRepository customerRepository;
	
	@Before
	public void setup()
	{
	    // Persist customers
	    customerRepository.save(new Customer("Dora", "dora@gmail.com"));
	    customerRepository.save(new Customer("Diego", "diego@gmail.com"));
	    customerRepository.save(new Customer("Boots", "boots@gmail.com"));
	    customerRepository.save(new Customer("Swiper", "swiper@gmail.com"));
	    customerRepository.save(new Customer("Tico", "tico@gmail.com"));
	}
	
	@Test
	public void searchForDora()
	{
	    List<Customer> customers = customerRepository.search("Dora");
	    assertThat(customers.size(), is(1));
	    
        assertThat(customers.get(0), allOf(
                hasProperty("id", is(1L)),
                hasProperty("name", is("Dora")),
                hasProperty("email", is("dora@gmail.com"))
        ));
	}
}
