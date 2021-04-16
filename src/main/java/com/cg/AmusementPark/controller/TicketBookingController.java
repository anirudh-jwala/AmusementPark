package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<TicketBooking> insertTicketBooking(@Valid @RequestBody TicketBooking ticketBooking,
			BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception("Ticket booking details provided are not valid, please try again!");
		}

		return new ResponseEntity<TicketBooking>(ticketBookingService.insertTicketBooking(ticketBooking),
				HttpStatus.CREATED);

	}

	@PutMapping(path = "/ticket")
	public ResponseEntity<TicketBooking> updateTicketBooking(TicketBooking ticketBooking)
			throws TicketBookingNotFoundException {

		return new ResponseEntity<TicketBooking>(ticketBookingService.updateTicketBooking(ticketBooking),
				HttpStatus.OK);

	}

	@DeleteMapping(path = "/ticket/{id}")
	public ResponseEntity<TicketBooking> deleteTicketBooking(@PathVariable("id") int ticketId)
			throws TicketBookingNotFoundException {

		return new ResponseEntity<TicketBooking>(ticketBookingService.deleteTicketBooking(ticketId), HttpStatus.OK);

	}

	@GetMapping(path = "/ticket/customer/{id}")
	public ResponseEntity<List<TicketBooking>> viewAllTicketsOfCustomer(@PathVariable("id") int customerId)
			throws CustomerNotFoundException {

		return new ResponseEntity<List<TicketBooking>>(ticketBookingService.viewAllTicketsOfCustomer(customerId),
				HttpStatus.OK);

	}

	@GetMapping(path = "/ticket/bill/{id}")
	public ResponseEntity<?> calculateBill(@PathVariable("id") int customerId) throws CustomerNotFoundException {

		return new ResponseEntity<>(ticketBookingService.calculateBill(customerId), HttpStatus.OK);

	}

}
