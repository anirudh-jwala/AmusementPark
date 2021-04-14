package com.cg.AmusementPark.repository;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;

public interface ITicketBookingRepository {

	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId);

	public float calculateBill(int customerId);

}
