package com.fireflysemantics.spring.domain.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.springframework.util.Assert.notNull;


@Entity
public class Customer extends AbstractPersistable<Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5606205093782977644L;
	
	private String firstName;
	private String email;

	/** Protected default constructor required by the JPA 2.0 Specification */
	protected Customer() {
	}

	public Customer(String firstName, String email) {
		notNull(firstName, "The customer name is null.");
		notNull(firstName, "The email address is null.");
		this.firstName = firstName;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, name='%s', email='%s']",
				this.getId(), firstName, email);
	}

	// ====================================================
	// Getters and Setters
	// ====================================================
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}