package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

public interface ICustomerService {

	public abstract Customer insertCustomer(Customer customer);

	public abstract Customer updateCustomer(Customer customer);

	public abstract Customer deleteCustomer(int customerId);

	public abstract List<Customer> viewCustomers();

	public abstract Customer viewCustomer(int customerId) throws CustomerNotFoundException;

	public abstract Customer validateCustomer(String email, String password) throws CustomerNotFoundException;

}
