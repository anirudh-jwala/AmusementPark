package com.cg.AmusementPark.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerExistsException;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@Test
	void shouldReturnAllCustomers() throws CustomerNotFoundException {

		List<Customer> mockCustomers = new ArrayList<>();
		mockCustomers.add(new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad", "7981970397"));
		mockCustomers.add(new Customer(2L, "bharath", "bharath@gmail.com", "bharath123", "Hyderabad", "7981970397"));

		Mockito.when(customerRepository.findAll()).thenReturn(mockCustomers);

		List<Customer> realCustomers = customerService.viewCustomers();

		assertEquals("anirudh", realCustomers.get(0).getUsername());

	}

	@Test
	void shouldReturnCustomerById() throws CustomerNotFoundException {

		List<Customer> mockCustomers = new ArrayList<>();
		mockCustomers.add(new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad", "7981970397"));
		mockCustomers.add(new Customer(2L, "bharath", "bharath@gmail.com", "bharath123", "Hyderabad", "7981970397"));
		mockCustomers.add(new Customer(3L, "shubham", "shubham@gmail.com", "shubham123", "Pune", "7981970397"));

		customerRepository.saveAll(mockCustomers);

		Mockito.when(customerRepository.findById(2L)).thenReturn(
				Optional.of(new Customer(2L, "bharath", "bharath@gmail.com", "bharath123", "Hyderabad", "7981970397")));

		Customer realCustomer = customerService.viewCustomer(2L);

		assertEquals("bharath", realCustomer.getUsername());

	}

	@Test
	void shouldAddCustomer() throws CustomerNotFoundException, CustomerExistsException {

		Customer mockCustomer = new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad",
				"7981970397");

		Mockito.when(customerRepository.save(mockCustomer)).thenReturn(mockCustomer);

		Customer realCustomer = customerService.insertCustomer(
				new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad", "7981970397"));

		assertEquals("anirudh@gmail.com", realCustomer.getEmail());
		assertEquals("7981970397", realCustomer.getMobileNumber());
		assertEquals("Hyderabad", realCustomer.getAddress());

	}

	@Test
	void shouldUpdateCustomer() throws CustomerNotFoundException, CustomerExistsException {

		Customer mockCustomer = new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad",
				"7981970397");

		Mockito.when(customerRepository.save(mockCustomer)).thenReturn(mockCustomer);
		Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(mockCustomer));

		customerService.insertCustomer(
				new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad", "7981970397"));

		Customer customerUpdated = customerService.findCustomerById(1L);
		customerUpdated.setAddress("Mumbai");
		customerUpdated.setEmail("anirudh@capgemini.com");

		assertEquals("anirudh@capgemini.com", customerUpdated.getEmail());
		assertEquals("Mumbai", customerUpdated.getAddress());

	}

}
