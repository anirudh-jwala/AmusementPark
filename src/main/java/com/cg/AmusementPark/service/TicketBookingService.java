package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.exception.TicketBookingNotFoundException;
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
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) throws TicketBookingNotFoundException {

		Optional<TicketBooking> searchedTicket = ticketBookingRepository.findById(ticketBooking.getTicketId());

		if (!searchedTicket.isPresent()) {
			throw new TicketBookingNotFoundException("Ticket Booking you are trying to update is not found or invalid");
		}

		return ticketBookingRepository.save(ticketBooking);

	}

	@Override
	public TicketBooking deleteTicketBooking(int ticketId) throws TicketBookingNotFoundException {

		Optional<TicketBooking> searchedTicket = ticketBookingRepository.findById(ticketId);

		if (!searchedTicket.isPresent()) {
			throw new TicketBookingNotFoundException("Ticket Booking you are trying to delete is not found or invalid");
		}

		TicketBooking ticket = searchedTicket.get();
		ticketBookingRepository.delete(ticket);
		return ticket;

	}

	@Override
	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId) throws CustomerNotFoundException {

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("No customer is found for specified ID");
		}

		return ticketBookingRepository.viewAllTicketsOfCustomer(customerId);

	}

	@Override
	public float calculateBill(int ticketId, int customerId) throws CustomerNotFoundException {

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("No customer is found for specified ID");
		}

		return ticketBookingRepository.calculateBill(ticketId, customerId);

	}

}
