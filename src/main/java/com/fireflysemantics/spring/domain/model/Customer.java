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
	private String name;
	private String email;

	protected Customer() {
	}

	public Customer(String name, String email) {
		notNull(name, "The customer name is null.");
		notNull(name, "The email address is null.");
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, name='%s', email='%s']",
				this.getId(), name, email);
	}

	// ====================================================
	// Getters and Setters
	// ====================================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}