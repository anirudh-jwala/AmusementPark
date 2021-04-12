package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.repository.TicketBookingRepository;

@Service
public class TicketBookingService implements ITicketBookingService {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;

	@Override
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking) {
		return ticketBookingRepository.save(ticketBooking);
	}

	@Override
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {

		Optional<TicketBooking> searchedTicket = ticketBookingRepository.findById(ticketBooking.getTicketId());

		if (searchedTicket.isPresent()) {
			return ticketBookingRepository.save(ticketBooking);
		} else {
			return null;
		}

	}

	@Override
	public TicketBooking deleteTicketBooking(int ticketId) {

		Optional<TicketBooking> searchedTicket = ticketBookingRepository.findById(ticketId);

		if (searchedTicket.isPresent()) {
			TicketBooking ticket = searchedTicket.get();
			ticketBookingRepository.delete(ticket);
			return ticket;
		} else {
			return null;
		}

	}

	@Override
	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId) {
		return ticketBookingRepository.viewAllTicketsOfCustomer(customerId);
	}

	@Override
	public float calculateBill(int customerId) {
		return 0.0f;
	}

}
