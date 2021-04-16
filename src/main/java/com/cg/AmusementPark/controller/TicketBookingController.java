package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.exception.TicketBookingNotFoundException;
import com.cg.AmusementPark.service.TicketBookingService;

@RestController
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(path = "/ticket")
	public TicketBooking insertTicketBooking(@Valid @RequestBody TicketBooking ticketBooking,
			BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception("Ticking booking details are not valid");
		}

		return ticketBookingService.insertTicketBooking(ticketBooking);

	}

	@PutMapping(path = "/ticket")
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) throws TicketBookingNotFoundException {

		return ticketBookingService.updateTicketBooking(ticketBooking);

	}

	@DeleteMapping(path = "/ticket/{id}")
	public TicketBooking deleteTicketBooking(@PathVariable("id") int ticketId) throws TicketBookingNotFoundException {

		return ticketBookingService.deleteTicketBooking(ticketId);

	}

	@GetMapping(path = "/ticket/customer/{id}")
	public List<TicketBooking> viewAllTicketsOfCustomer(@PathVariable("id") int customerId)
			throws CustomerNotFoundException {

		return ticketBookingService.viewAllTicketsOfCustomer(customerId);

	}

	@GetMapping(path = "/ticket/bill/{id}")
	public float calculateBill(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		return ticketBookingService.calculateBill(customerId);

	}

}
