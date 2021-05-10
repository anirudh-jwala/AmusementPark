package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.exception.TicketBookingNotFoundException;

public interface ITicketBookingService {

	TicketBooking insertTicketBooking(TicketBooking ticketBooking);

	List<TicketBooking> viewAllTicketsOfCustomer(Long customerId) throws CustomerNotFoundException;

	float calculateBill(int ticketId, Long customerId) throws CustomerNotFoundException, TicketBookingNotFoundException;

	List<TicketBooking> viewAllTickets() throws TicketBookingNotFoundException;

}
