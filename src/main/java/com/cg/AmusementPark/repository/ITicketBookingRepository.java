package com.cg.AmusementPark.repository;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

public interface ITicketBookingRepository {

	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId) throws CustomerNotFoundException;

	public float calculateBill(int customerId) throws CustomerNotFoundException;

}
