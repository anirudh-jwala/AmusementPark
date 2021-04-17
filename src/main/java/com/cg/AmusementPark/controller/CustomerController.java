package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import com.cg.AmusementPark.exception.InvalidCustomerException;
import com.cg.AmusementPark.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/customer")
	public ResponseEntity<Customer> insertCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerExistsException, InvalidCustomerException {

		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidCustomerException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Customer>(customerService.insertCustomer(customer), HttpStatus.CREATED);

	}

	@PutMapping(path = "/customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerNotFoundException, Exception {

		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidCustomerException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);

	}

	@DeleteMapping(path = "/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int customerId)
			throws CustomerNotFoundException {

		return new ResponseEntity<Customer>(customerService.deleteCustomer(customerId), HttpStatus.OK);

	}

	@GetMapping(path = "/customer")
	public ResponseEntity<List<Customer>> viewCustomers() throws CustomerNotFoundException {

		return new ResponseEntity<List<Customer>>(customerService.viewCustomers(), HttpStatus.OK);

	}

	@GetMapping(path = "/customer/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);

	}

	@PostMapping(path = "/customer/auth")
	public ResponseEntity<Customer> validateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerNotFoundException, InvalidCustomerException {

		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidCustomerException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Customer>(
				customerService.validateCustomer(customer.getEmail(), customer.getPassword()), HttpStatus.OK);

	}

}
