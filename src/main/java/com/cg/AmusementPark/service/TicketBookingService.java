package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking) {

		logger.info("Called insertTicketBooking() method of TicketBookingService");

		return ticketBookingRepository.save(ticketBooking);

	}

	@Override
	public List<TicketBooking> viewAllTickets() throws TicketBookingNotFoundException {

		logger.info("Called viewAllTickets() method of TicketBookingService");

		List<TicketBooking> tickets = ticketBookingRepository.findAll();

		System.out.println(tickets);

		if (tickets.isEmpty()) {
			throw new TicketBookingNotFoundException("No tickets are found");
		}

		return tickets;

	}

	@Override
	public List<TicketBooking> viewAllTicketsOfCustomer(Long customerId) throws CustomerNotFoundException {

		logger.info("Called viewAllTicketsOfCustomer() method of TicketBookingService");

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("No customer is found for specified ID");
		}

		return ticketBookingRepository.viewAllTicketsOfCustomer(customerId);

	}

	@Override
	public float calculateBill(int ticketId, Long customerId)
			throws CustomerNotFoundException, TicketBookingNotFoundException {

		logger.info("Called calculateBill() method of TicketBookingService");

		Optional<TicketBooking> ticket = ticketBookingRepository.findById(ticketId);
		Optional<Customer> customer = customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("No customer is found for specified ID");
		} else if (!ticket.isPresent()) {
			throw new TicketBookingNotFoundException("No ticket is found for specified ID");
		} else {
			return ticketBookingRepository.calculateBill(ticketId, customerId);
		}

	}

}
