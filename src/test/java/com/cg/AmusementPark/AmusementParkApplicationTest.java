package com.cg.AmusementPark;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.cg.AmusementPark.controller.ActivityController;
import com.cg.AmusementPark.controller.CustomerController;
import com.cg.AmusementPark.controller.TicketBookingController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmusementParkApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
class AmusementParkApplicationTest {

	@Autowired
	ActivityController acitivityController;

	@Autowired
	CustomerController customerController;

	@Autowired
	TicketBookingController ticketBookingController;

	@Autowired
	MockMvc mockMvc;

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

	@Test
	public void shouldCheckCustomerEmail() throws Exception {
		this.mockMvc.perform(get("/customer/1")).andDo(print())
				.andExpect((ResultMatcher) jsonPath("email", is("sanjay@gmail.com")));
	}

}
