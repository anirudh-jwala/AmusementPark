package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerExistsException;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/customer")
	public Customer insertCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerExistsException, Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception("Customer details are not valid");
		}

		return customerService.insertCustomer(customer);

	}

	@PutMapping(path = "/customer")
	public Customer updateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerNotFoundException, Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception("Customer details are not valid");
		}

		return customerService.updateCustomer(customer);

	}

	@DeleteMapping(path = "/customer/{id}")
	public Customer deleteCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		return customerService.deleteCustomer(customerId);

	}

	@GetMapping(path = "/customer")
	public List<Customer> viewCustomers() throws CustomerNotFoundException {

		return customerService.viewCustomers();

	}

	@GetMapping(path = "/customer/{id}")
	public Customer viewCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		return customerService.viewCustomer(customerId);

	}

	@PostMapping(path = "/customer/auth")
	public Customer validateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {

		return customerService.validateCustomer(customer.getEmail(), customer.getPassword());

	}

}
