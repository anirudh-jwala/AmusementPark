package com.cg.AmusementPark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.AmusementPark.entities.TicketBooking;

/**
 * User defined repository functions for ticket booking repository
 */
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

	/**
	 * Get list of all ticket booking for a specific customer id
	 */
	@Query("SELECT tb FROM TicketBooking tb WHERE tb.customer.customerId = ?1 order by tb.ticketId desc")
	List<TicketBooking> viewAllTicketsOfCustomer(Long customerId);

	/**
	 * Calculate the total ticket amount based on customer and ticket id
	 */
	@Query(nativeQuery = true, value = "SELECT SUM(a.charges) FROM activity a where a.activity_id IN (SELECT tba.activities_activity_id FROM ticket_booking tb INNER JOIN ticket_booking_activities tba ON tb.ticket_id = tba.ticket_booking_ticket_id WHERE tb.ticket_id = ?1 AND tb.customer_id = ?2)")
	float calculateBill(int ticketId, Long customerId);

}
