package com.cg.AmusementPark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerExistsException;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/customer")//, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer insertCustomer(@RequestBody Customer customer) throws CustomerExistsException {
		if(customerService.insertCustomer(customer)==null)
		{
			CustomerExistsException customerException = new CustomerExistsException("you are trying to insert is already exists");
			throw customerException; 
		}
		return customerService.insertCustomer(customer);
	}

	@PutMapping(path = "/customer")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {

		Customer customerToUpdate = customerService.updateCustomer(customer);

		if (customerToUpdate == null) {
			CustomerNotFoundException customerException = new CustomerNotFoundException(
					"Customer you are trying to update is not found or invalid");
			throw customerException;
		}

		return customerToUpdate;
	}

	@DeleteMapping(path = "/customer/{id}")
	public Customer deleteCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		Customer customerToDelete = customerService.deleteCustomer(customerId);

		if (customerToDelete == null) {
			CustomerNotFoundException customerException = new CustomerNotFoundException(
					"Customer you are trying to delete is not found or invalid");
			throw customerException;
		}

		return customerToDelete;
	}

	@GetMapping(path = "/customer")
	public List<Customer> viewCustomers() throws CustomerNotFoundException {

		List<Customer> customers = customerService.viewCustomers();

		if (customers == null) {
			CustomerNotFoundException customerException = new CustomerNotFoundException("No customers are available");
			throw customerException;
		}

		return customers;
	}

	@GetMapping(path = "/customer/{id}")
	public Customer viewCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		Customer customer = customerService.viewCustomer(customerId);

		if (customer == null) {
			CustomerNotFoundException customerException = new CustomerNotFoundException(
					"No customer is available with provided ID");
			throw customerException;
		}

		return customer;

	}

	@PostMapping(path = "/customer/auth")
	public Customer validateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {

		Customer customerToValidate = customerService.validateCustomer(customer.getEmail(), customer.getPassword());

		if (customerToValidate == null) {
			CustomerNotFoundException customerException = new CustomerNotFoundException(
					"Customer details mentioned are not valid");
			throw customerException;
		}

		return customerToValidate;
	}

}
