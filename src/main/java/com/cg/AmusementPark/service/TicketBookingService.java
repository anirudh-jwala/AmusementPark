package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.repository.CustomerRepository;
import com.cg.AmusementPark.repository.TicketBookingRepository;

@Service
public class TicketBookingService implements ITicketBookingService {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking) {
		return ticketBookingRepository.save(ticketBooking);
	}

	@Override
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {

		Optional<TicketBooking> searchedTicket = ticketBookingRepository.findById(ticketBooking.getTicketId());

		if (searchedTicket.isPresent()) {
			return ticketBookingRepository.save(ticketBooking);
		}

		return null;

	}

	@Override
	public TicketBooking deleteTicketBooking(int ticketId) {

		Optional<TicketBooking> searchedTicket = ticketBookingRepository.findById(ticketId);

		if (searchedTicket.isPresent()) {
			TicketBooking ticket = searchedTicket.get();
			ticketBookingRepository.delete(ticket);
			return ticket;
		}

		return null;

	}

	@Override
	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (customer.isPresent()) {
			return ticketBookingRepository.viewAllTicketsOfCustomer(customerId);
		}

		return null;

	}

	@Override
	public float calculateBill(int customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (customer.isPresent()) {
			return ticketBookingRepository.calculateBill(customerId);
		}

		return 0.0f;

	}

}
