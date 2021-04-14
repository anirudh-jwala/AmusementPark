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

	@Query(nativeQuery = true, value = "SELECT SUM(a.charges) FROM activity a where a.acitivity_id IN (SELECT tba.activities_acitivity_id FROM ticket_booking tb INNER JOIN ticket_booking_activities tba ON tb.ticket_id = tba.ticket_booking_ticket_id WHERE tb.customer_id = ?1)")
	public float calculateBill(int customerId);

}
