package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * TODO: Add CustomerExistsException
	 */
	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	/**
	 * TODO: Add CustomerNotFoundException
	 */
	@Override
	public Customer updateCustomer(Customer customer) {

		Optional<Customer> searchedCustomer = customerRepository.findById(customer.getCustomerId());

		if (searchedCustomer.isPresent()) {
			return customerRepository.save(customer);
		} else {
			return null;
		}

	}

	/**
	 * TODO: Add CustomerNotFoundException
	 */
	@Override
	public Customer deleteCustomer(int customerId) {

		Optional<Customer> searchedCustomer = customerRepository.findById(customerId);

		if (searchedCustomer.isPresent()) {
			Customer deleteCustomer = searchedCustomer.get();
			customerRepository.delete(deleteCustomer);
			return deleteCustomer;
		} else {
			return null;
		}

	}

	@Override
	public List<Customer> viewCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) {

		Optional<Customer> searchedCustomer = customerRepository.findById(customerId);

		if (searchedCustomer.isPresent()) {
			return customerRepository.viewCustomer(customerId);
		} else {
			return null;
		}

	}

	@Override
	public Customer validateCustomer(String username, String password) {
		return customerRepository.validateCustomer(username, password);
	}

}
