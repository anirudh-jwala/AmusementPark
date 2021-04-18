package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param customer
	 * @param bindingResult
	 * @return ResponseEntity<Customer>
	 * @throws CustomerExistsException
	 * @throws InvalidCustomerException
	 * 
	 * Add a new customer record to database
	 * 
	 */
	@PostMapping(path = "/customer")
	public ResponseEntity<Customer> insertCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerExistsException, InvalidCustomerException {

		logger.info("Called POST mapping insertCustomer() method");
		
		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidCustomerException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Customer>(customerService.insertCustomer(customer), HttpStatus.CREATED);

	}

	/**
	 * @param customer
	 * @param bindingResult
	 * @return ResponseEntity<Customer>
	 * @throws CustomerNotFoundException
	 * @throws Exception
	 * 
	 * Update an existing record of customer in database
	 * 
	 */
	@PutMapping(path = "/customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerNotFoundException, Exception {

		logger.info("Called PUT mapping updateCustomer() method");
		
		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidCustomerException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);

	}

	/**
	 * @param customerId
	 * @return ResponseEntity<Customer>
	 * @throws CustomerNotFoundException
	 * 
	 * Delete an existing customer record in database, else throw CustomerNotFoundException
	 * 
	 */
	@DeleteMapping(path = "/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int customerId)
			throws CustomerNotFoundException {
		
		logger.info("Called DELETE mapping deleteCustomer() method");

		return new ResponseEntity<Customer>(customerService.deleteCustomer(customerId), HttpStatus.OK);

	}

	/**
	 * @return ResponseEntity<List<Customer>>
	 * @throws CustomerNotFoundException
	 * 
	 * Get list of all customers available in database
	 * 
	 */
	@GetMapping(path = "/customer")
	public ResponseEntity<List<Customer>> viewCustomers() throws CustomerNotFoundException {

		logger.info("Called GET mapping viewCustomers() method");
		
		return new ResponseEntity<List<Customer>>(customerService.viewCustomers(), HttpStatus.OK);

	}

	/**
	 * @param customerId
	 * @return ResponseEntity<Customer>
	 * @throws CustomerNotFoundException
	 * 
	 * Get a specific custom based on the provided customer id
	 * 
	 */
	@GetMapping(path = "/customer/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		logger.info("Called GET mapping viewCustomer() method");
		
		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);

	}

	/**
	 * @param customer
	 * @param bindingResult
	 * @return ResponseEntity<Customer>
	 * @throws CustomerNotFoundException
	 * @throws InvalidCustomerException
	 * 
	 * Validate the customer record based on email id and password 
	 * 
	 */
	@PostMapping(path = "/customer/auth")
	public ResponseEntity<Customer> validateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult)
			throws CustomerNotFoundException, InvalidCustomerException {

		logger.info("Called POST mapping validateCustomer() method");
		
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
