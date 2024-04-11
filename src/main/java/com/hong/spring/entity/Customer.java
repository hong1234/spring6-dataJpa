package com.hong.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


// import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer2")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// private Long id;
	
	private String firstName;
	
	private String lastName;

	// public Customer() {
	// }

	// public Long getId() {
	// 	return id;
	// }

	// public void setId(Long id) {
	// 	this.id = id;
	// }

	// public String getFirstName() {
	// 	return firstName;
	// }

	// public void setFirstName(String firstName) {
	// 	this.firstName = firstName;
	// }

	// public String getLastName() {
	// 	return lastName;
	// }

	// public void setLastName(String lastName) {
	// 	this.lastName = lastName;
	// }

	// @Override
	// public String toString() {
	// 	return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	// }

}
