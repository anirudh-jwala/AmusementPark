package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerExistsException;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerExistsException {

		logger.info("Called insertCustomer() method of CustomerService");
		
		Customer searchedCustomer = customerRepository.findByCustomerEmail(customer.getEmail());

		if (searchedCustomer != null && customer.getEmail().equals(searchedCustomer.getEmail())) {
			throw new CustomerExistsException("Customer you are trying to insert already exists");
		}

		return customerRepository.save(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {

		logger.info("Called updateCustomer() method of CustomerService");
		
		Optional<Customer> searchedCustomer = customerRepository.findById(customer.getCustomerId());

		if (!searchedCustomer.isPresent()) {
			throw new CustomerNotFoundException("Customer you are trying to update is not found or invalid");
		}

		return customerRepository.save(customer);

	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {

		logger.info("Called deleteCustomer() method of CustomerService");
		
		Optional<Customer> searchedCustomer = customerRepository.findById(customerId);

		if (!searchedCustomer.isPresent()) {
			throw new CustomerNotFoundException("Customer you are trying to delete is not found or invalid");
		}

		Customer deleteCustomer = searchedCustomer.get();
		customerRepository.delete(deleteCustomer);
		return deleteCustomer;

	}

	@Override
	public List<Customer> viewCustomers() throws CustomerNotFoundException {

		logger.info("Called viewCustomers() method of CustomerService");
		
		List<Customer> customers = customerRepository.findAll();

		if (customers.size() == 0) {
			throw new CustomerNotFoundException("No customers are available");
		}

		return customers;

	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {

		logger.info("Called viewCustomer() method of CustomerService");
		
		Optional<Customer> searchedCustomer = customerRepository.findById(customerId);

		if (!searchedCustomer.isPresent()) {
			throw new CustomerNotFoundException("No customer is available with provided ID");
		}

		// return customerRepository.viewCustomer(customerId);
		return customerRepository.findById(customerId).get();

	}

	@Override
	public Customer validateCustomer(String email, String password) throws CustomerNotFoundException {

		logger.info("Called validateCustomer() method of CustomerService");
		
		Customer customer = customerRepository.validateCustomer(email, password);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer details mentioned are not valid");
		}

		return customer;

	}
	
	public Customer findCustomerById(int customerId) {
		return customerRepository.findById(customerId).get();
	}

}
