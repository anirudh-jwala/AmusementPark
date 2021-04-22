package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerExistsException;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

public interface ICustomerService {

    Customer insertCustomer(Customer customer) throws CustomerExistsException;

    Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

    Customer deleteCustomer(int customerId) throws CustomerNotFoundException;

    List<Customer> viewCustomers() throws CustomerNotFoundException;

    Customer viewCustomer(int customerId) throws CustomerNotFoundException;

    Customer validateCustomer(String email, String password) throws CustomerNotFoundException;

}
