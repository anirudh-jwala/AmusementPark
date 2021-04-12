package com.cg.AmusementPark.repository;

import com.cg.AmusementPark.entities.Customer;

public interface ICustomerRepository {

	public Customer viewCustomer(int customerId);

	public Customer validateCustomer(String username, String password);

}
