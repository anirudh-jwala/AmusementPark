package com.cg.AmusementPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

/**
 * User defined repository functions for customer repository
 */
public interface CustomerRepository extends ICustomerRepository, JpaRepository<Customer, Integer> {

	/**
	 * @param email
	 * @return Customer
	 * 
	 * Get a single customer based on customer email id
	 * 
	 */
	@Query("SELECT c FROM Customer c WHERE c.email = ?1")
	public Customer findByCustomerEmail(String email);

	/**
	 * @param customerId
	 * @return Customer
	 * 
	 * Get a single customer based on customer id
	 * 
	 */
	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;

	/**
	 * @param email
	 * @param password
	 * @return Customer
	 * 
	 *  Validate an existing customer record based on the email and password
	 *  
	 */
	@Query("SELECT c FROM Customer c WHERE c.email = ?1 AND c.password = ?2")
	public Customer validateCustomer(String email, String password) throws CustomerNotFoundException;

}
