package com.cg.AmusementPark.repository;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

public interface ICustomerRepository {

    Customer viewCustomer(int customerId) throws CustomerNotFoundException;

    Customer validateCustomer(String username, String password) throws CustomerNotFoundException;

}
