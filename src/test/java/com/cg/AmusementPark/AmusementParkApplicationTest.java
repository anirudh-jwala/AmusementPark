package com.cg.AmusementPark;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.entities.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmusementParkApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
class AmusementParkApplicationTest {

	@Autowired
	MockMvc mockMvc;

	/**
	 * Customer controller testing
	 */
	@Test
	public void shouldCheckCustomerEmailById() throws Exception {
		this.mockMvc
				.perform(get("/customer/{id}", 1))
				.andDo(print())
				.andExpect((ResultMatcher) jsonPath("email", is("sanjay@gmail.com")));
	}

	@Test
	public void shouldCheckCustomerDetails() throws Exception {
		this.mockMvc
				.perform(get("/customer"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].customerId").exists())
				.andExpect(jsonPath("$.[0].mobileNumber", is("9848012345")));
	}

	@Test
	public void shouldCheckOneCustomerNameAndTicketDetails() throws Exception {
		this.mockMvc
				.perform(get("/customer/{id}", 1))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username", is("sanjay")))
				.andExpect(jsonPath("$.tickets[0].ticketId", is(1)));
	}

	@Test
	public void shouldAddCustomer() throws Exception {
		this.mockMvc
				.perform(post("/customer")
				.content(asJsonString(new Customer(5, "shubham", "shubham@gmail.com", "shubham123", "Pune", "9848012345")))
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
			    .andExpect(status().isCreated())
			    .andExpect(jsonPath("$.customerId", is(5)));
	}

	@Test
	public void shouldUpdateCustomer() throws Exception {
		this.mockMvc
				.perform(put("/customer")
				.content(asJsonString(new Customer(3, "bharath", "bharath@capgemini.com", "bharath123456", "Hyderabad", "9848012345")))
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(jsonPath("$.email", is("bharath@capgemini.com")));
	}

	@Test
	public void shouldDeleteCustomer() throws Exception {
		this.mockMvc
				.perform(delete("/customer/{id}", 4))
				.andExpect(status().isOk());
	}
	
	/**
	 * Activity controller testing
	 */
	@Test
	public void shouldGetActivitiesOfCharges() throws Exception {
		this.mockMvc
				.perform(get("/activity/{amount}", 500.0f))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].activityId").exists())
				.andExpect(jsonPath("$.[0].activityName", is("Jungle Safari")));
	}
	
	@Test
	public void shouldGetCountOfActivitiesOfCharges() throws Exception {
		this.mockMvc
				.perform(get("/activity/{amount}", 500.0f))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("2")));
	}
	
	@Test
	public void shouldAddActivity() throws Exception {
		this.mockMvc
				.perform(post("/activity")
				.content(asJsonString(new Activity(5, "Lazer show", "For kids and adults", 250.0f)))
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
			    .andExpect(status().isCreated())
			    .andExpect(jsonPath("$.activityId", is(5)));
	}
	
	@Test
	public void shouldUpdateActivity() throws Exception {
		this.mockMvc
				.perform(put("/activity")
				.content(asJsonString(new Activity(5, "Lazer show", "For kids and adults", 350.0f)))
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(jsonPath("$.charges", is(350.0)));
	}
	
	@Test
	public void shouldDeleteActivity() throws Exception {
		this.mockMvc
				.perform(delete("/activity/{id}", 3))
				.andExpect(status().isOk());
	}

	public String asJsonString(Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}