package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer insertCustomer(Customer customer) {
		Optional<Customer> searchedCustomer = customerRepository.findById(customer.getCustomerId());
		if (searchedCustomer.isPresent()) {
			return null;
		}
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Optional<Customer> searchedCustomer = customerRepository.findById(customer.getCustomerId());

		if (searchedCustomer.isPresent()) {
			return customerRepository.save(customer);
		} else {
			return null;
		}

	}

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
		List<Customer> customers = customerRepository.findAll();

		if (customers.size() == 0)
			return null;

		return customers;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {

		Optional<Customer> searchedCustomer = customerRepository.findById(customerId);

		if (searchedCustomer.isPresent()) {
			return customerRepository.viewCustomer(customerId);
		} else {
			return null;
		}

	}

	@Override
	public Customer validateCustomer(String email, String password) throws CustomerNotFoundException {
		Customer customer = customerRepository.validateCustomer(email, password);

		if (customer != null)
			return customer;

		return null;
	}

}
