package com.cg.AmusementPark.repository;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;

public interface ITicketBookingRepository {

    List<TicketBooking> viewAllTicketsOfCustomer(int customerId) throws CustomerNotFoundException;

    float calculateBill(int ticketId, int customerId) throws CustomerNotFoundException;

}
