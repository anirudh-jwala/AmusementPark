package com.cg.AmusementPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

@Repository
public interface CustomerRepository extends ICustomerRepository, JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.email = ?1")
	public Customer findByCustomerEmail(String email);

	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;

	@Query("SELECT c FROM Customer c WHERE c.email = ?1 AND c.password = ?2")
	public Customer validateCustomer(String email, String password) throws CustomerNotFoundException;

}
