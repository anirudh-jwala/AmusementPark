package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.exception.TicketBookingNotFoundException;

public interface ITicketBookingService {

	public TicketBooking insertTicketBooking(TicketBooking ticketBooking);

	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) throws TicketBookingNotFoundException;

	public TicketBooking deleteTicketBooking(int ticketId) throws TicketBookingNotFoundException;

	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId) throws CustomerNotFoundException;

	public float calculateBill(int customerId) throws CustomerNotFoundException;

}
