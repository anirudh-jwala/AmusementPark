package com.cg.AmusementPark.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.entities.TicketBooking;
import com.cg.AmusementPark.repository.TicketBookingRepository;

@ExtendWith(MockitoExtension.class)
class TicketBookingServiceTest {

	@Mock
	private TicketBookingRepository ticketBookingRepository;

	@InjectMocks
	private TicketBookingService ticketBookingService;

	@Test
	void shouldAddTicketBookings() {
		LocalDate date = null;

		Customer mockCustomer = new Customer(1L, "anirudh", "anirudh@gmail.com", "anirudh123", "Hyderabad",
				"7981970397");

		List<Activity> mockActivities = new ArrayList<>();
		mockActivities.add(new Activity(1, "Swimming", "Best for summer", 500.0f));
		mockActivities.add(new Activity(2, "Gaint Wheel", "Enjoy with family", 350.0f));

		TicketBooking mockTicket = new TicketBooking(1, date, 850.0f, mockCustomer, mockActivities);

		ticketBookingRepository.save(mockTicket);

		Mockito.when(ticketBookingRepository.save(mockTicket)).thenReturn(mockTicket);

		TicketBooking realTicket = ticketBookingService
				.insertTicketBooking(new TicketBooking(1, date, 850.0f, mockCustomer, mockActivities));

		assertEquals("Swimming", realTicket.getActivities().get(0).getActivityName());
		assertEquals("Enjoy with family", realTicket.getActivities().get(1).getDescription());

	}

}
