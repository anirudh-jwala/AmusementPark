package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;

public interface ITicketBookingService {

	public TicketBooking insertTicketBooking(TicketBooking ticketBooking);

	public TicketBooking updateTicketBooking(TicketBooking ticketBooking);

	public TicketBooking deleteTicketBooking(int ticketId);

	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId);

	public TicketBooking calculateBill(int customerId);

}
