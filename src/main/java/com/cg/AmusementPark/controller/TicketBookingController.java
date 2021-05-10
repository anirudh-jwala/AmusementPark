package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.exception.InvalidTicketBookingException;
import com.cg.AmusementPark.exception.TicketBookingNotFoundException;
import com.cg.AmusementPark.service.TicketBookingService;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin("*")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Add a new record of ticket booking to database
	 */
	@PostMapping
	public ResponseEntity<TicketBooking> insertTicketBooking(@Valid @RequestBody TicketBooking ticketBooking,
			BindingResult bindingResult) throws InvalidTicketBookingException {

		logger.info("Called POST mapping insertTicketBooking() method");

		if (bindingResult.hasErrors()) {
			throw new InvalidTicketBookingException("Ticket booking details are invalid");
		}

		return new ResponseEntity<>(ticketBookingService.insertTicketBooking(ticketBooking), HttpStatus.CREATED);

	}

	/**
	 * Get list of all tickets
	 * 
	 * @throws TicketBookingNotFoundException
	 */
	@GetMapping
	public ResponseEntity<List<TicketBooking>> viewAllTickets() throws TicketBookingNotFoundException {

		logger.info("Called GET mapping viewAllTickets() method");

		return new ResponseEntity<>(ticketBookingService.viewAllTickets(), HttpStatus.OK);

	}

	/**
	 * Get list of all tickets for a specified customer id
	 */
	@GetMapping(path = "/{customerId}")
	public ResponseEntity<List<TicketBooking>> viewAllTicketsOfCustomer(@PathVariable("customerId") Long customerId)
			throws CustomerNotFoundException {

		logger.info("Called GET mapping viewAllTicketsOfCustomer() method");

		return new ResponseEntity<>(ticketBookingService.viewAllTicketsOfCustomer(customerId), HttpStatus.OK);

	}

	/**
	 * Calculate the entire bill amount of a ticket booking based on customer id and
	 * ticket id
	 */
	@GetMapping(path = "/bill/{ticketId}&{customerId}")
	public ResponseEntity<Float> calculateBill(@PathVariable("ticketId") int ticketId,
			@PathVariable("customerId") Long customerId)
			throws CustomerNotFoundException, TicketBookingNotFoundException {

		logger.info("Called GET mapping calculateBill() method");

		return new ResponseEntity<>(ticketBookingService.calculateBill(ticketId, customerId), HttpStatus.OK);

	}

}
