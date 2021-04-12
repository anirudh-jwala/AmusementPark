package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.Customer;

public interface ICustomerService {

	public abstract Customer insertCustomer(Customer customer);

	public abstract Customer updateCustomer(Customer customer);

	public abstract Customer deleteCustomer(int customerId);

	public abstract List<Customer> viewCustomers();

	public abstract Customer viewCustomer(int customerId);

	public abstract Customer validateCustomer(String username, String password);

}
