package com.cg.AmusementPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.AmusementPark.entities.Customer;

@Repository
public interface CustomerRepository extends ICustomerRepository, JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	public Customer viewCustomer(int customerId);

	@Query("SELECT c FROM Customer c WHERE c.username = ?1 AND c.password = ?2")
	public Customer validateCustomer(String username, String password);

}
