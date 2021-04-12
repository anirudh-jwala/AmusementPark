package com.cg.AmusementPark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/customer")
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}

	@PutMapping(path = "/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping(path = "/customer/{id}")
	public Customer deleteCustomer(@PathVariable("id") int customerId) {
		return customerService.deleteCustomer(customerId);
	}

	@GetMapping(path = "/customer")
	public List<Customer> viewCustomers() {
		return customerService.viewCustomers();
	}

	@GetMapping(path = "/customer/{id}")
	public Customer viewCustomer(@PathVariable("id") int customerId) {
		return customerService.viewCustomer(customerId);
	}

	@PostMapping(path = "/customer/auth")
	public Customer validateCustomer(@RequestBody Customer customer) {
		return customerService.validateCustomer(customer.getUsername(), customer.getPassword());
	}

}
