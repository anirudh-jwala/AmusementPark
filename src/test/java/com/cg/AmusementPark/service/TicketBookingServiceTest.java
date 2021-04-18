package com.cg.AmusementPark.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.repository.TicketBookingRepository;

@ExtendWith(MockitoExtension.class)
class TicketBookingServiceTest {

	@Mock
	private TicketBookingRepository ticketBookingRepository;
	
	@InjectMocks
	private TicketBookingService ticketBookingService;
	
	@Test
	void shouldAddTicketBooking() {
		
	}

}
