package com.fireflysemantics.spring.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fireflysemantics.spring.domain.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);
   
    
    /**
     * Search for Customer instances using a search term.  The search is not case sensitive.
     * @param searchTerm
     * @return
     */
    @Query(
            "Select c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(c.email) LIKE LOWER(CONCAT('%', :searchTerm, '%'))"
    )
    public List<Customer> search(@Param("searchTerm") String searchTerm);
    
}
