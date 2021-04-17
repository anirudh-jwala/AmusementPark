package com.cg.AmusementPark;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cg.AmusementPark.controller.ActivityController;
import com.cg.AmusementPark.controller.CustomerController;
import com.cg.AmusementPark.controller.TicketBookingController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmusementParkApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
class AmusementParkApplicationTest {

	@Autowired
	private ActivityController acitivityController;

	@Autowired
	private CustomerController customerController;

	@Autowired
	private TicketBookingController ticketBookingController;

	@Test
	void activityControllerIsNotNull() {
		assertThat(acitivityController).isNotNull();
	}

	@Test
	void customerControllerIsNotNull() {
		assertThat(customerController).isNotNull();
	}

	@Test
	void ticketBookingControllerIsNotNull() {
		assertThat(ticketBookingController).isNotNull();
	}

}
