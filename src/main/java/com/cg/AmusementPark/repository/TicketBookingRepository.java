package com.cg.AmusementPark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.AmusementPark.entities.TicketBooking;

@Repository
public interface TicketBookingRepository extends ITicketBookingRepository, JpaRepository<TicketBooking, Integer> {

	@Query("SELECT tb FROM TicketBooking tb WHERE tb.customer.customerId = ?1")
	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId);

//	@Query("SELECT SUM() FROM TicketBooking tb WHERE tb.customer.customerId = ?1")
//	public float calculateBill(int customerId);

}
