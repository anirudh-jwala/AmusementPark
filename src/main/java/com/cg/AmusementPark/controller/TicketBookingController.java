package com.cg.AmusementPark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.service.TicketBookingService;

@RestController
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(path = "/ticket")
	public TicketBooking insertTicketBooking(@RequestBody TicketBooking ticketBooking) {
		return ticketBookingService.insertTicketBooking(ticketBooking);
	}

	@PostMapping
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {
		return ticketBookingService.updateTicketBooking(ticketBooking);
	}

	@DeleteMapping
	public TicketBooking deleteTicketBooking(int ticketId) {
		return ticketBookingService.deleteTicketBooking(ticketId);
	}

	@GetMapping
	public List<TicketBooking> viewAllTicketsOfCustomer(int customerId) {
		return ticketBookingService.viewAllTicketsOfCustomer(customerId);
	}

}
