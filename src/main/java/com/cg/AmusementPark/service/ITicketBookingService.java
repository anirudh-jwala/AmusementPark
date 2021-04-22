package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.exception.TicketBookingNotFoundException;

public interface ITicketBookingService {

    TicketBooking insertTicketBooking(TicketBooking ticketBooking);

    TicketBooking updateTicketBooking(TicketBooking ticketBooking) throws TicketBookingNotFoundException;

    TicketBooking deleteTicketBooking(int ticketId) throws TicketBookingNotFoundException;

    List<TicketBooking> viewAllTicketsOfCustomer(int customerId) throws CustomerNotFoundException;

    float calculateBill(int ticketId, int customerId) throws CustomerNotFoundException;

}
