package com.cg.AmusementPark;

//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;

//import com.fasterxml.jackson.databind.ObjectMapper;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @ContextConfiguration(classes = AmusementParkApplication.class)
// @WebAppConfiguration
// @AutoConfigureMockMvc
@SpringBootTest
class AmusementParkApplicationTest {

//    @Autowired
//    MockMvc mockMvc;

    /**
     * Customer testing
     */
//    @Test
//    void shouldCheckCustomerEmailById() throws Exception {
//        this.mockMvc.perform(get("/customer/{id}", 1)).andDo(print())
//                .andExpect((ResultMatcher) jsonPath("email", is("sanjay@gmail.com")));
//    }

//    @Test
//    void shouldCheckCustomerDetails() throws Exception {
//        this.mockMvc.perform(get("/customer")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.[0].customerId").exists())
//                .andExpect(jsonPath("$.[0].mobileNumber", is("9848012345")));
//    }

//    @Test
//    void shouldCheckOneCustomerNameAndTicketDetails() throws Exception {
//        this.mockMvc.perform(get("/customer/{id}", 1)).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.username", is("sanjay"))).andExpect(jsonPath("$.tickets[0].ticketId", is(2)));
//    }

//	@Test
//	void shouldAddCustomer() throws Exception {
//		this.mockMvc
//				.perform(post("/customer")
//				.content(asJsonString(
//				new Customer(6, "saitejac", "sai@gmail.com", "saiteja123", "Hyderabad", "9848012345")))
//				.contentType(MediaType.APPLICATION_JSON)
// 				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated())
//				.andExpect(jsonPath("$.customerId", is(6)));
//	}

//	@Test
//	void shouldUpdateCustomer() throws Exception {
//		this.mockMvc
//				.perform(put("/customer")
//						.content(asJsonString(
//								new Customer(6, "sai teja", "sai@capgemini.com", "sai123", "Hyderabad", "9848012345")))
//						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(jsonPath("$.email", is("sai@capgemini.com")));
//	}

//	@Test
//	void shouldDeleteCustomer() throws Exception {
//		this.mockMvc.perform(delete("/customer/{id}", 5)).andExpect(status().isOk());
//	}

    /**
     * Activity testing
     */
//    @Test
//    void shouldGetActivitiesOfCharges() throws Exception {
//        this.mockMvc.perform(get("/activity/{amount}", 500.0f)).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.[0].activityId").exists())
//                .andExpect(jsonPath("$.[0].activityName", is("Jungle Safari")));
//    }

//    @Test
//    void shouldGetCountOfActivitiesOfCharges() throws Exception {
//        this.mockMvc.perform(get("/activity/{amount}", 500.0f)).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("2")));
//    }

//	@Test
//	void shouldAddActivity() throws Exception {
//		this.mockMvc
//				.perform(post("/activity").content(asJsonString(new Activity(6, "Gaint wheel", "For adults", 550.0f)))
//						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated()).andExpect(jsonPath("$.activityId", is(6)));
//	}

//	@Test
//	void shouldUpdateActivity() throws Exception {
//		this.mockMvc
//				.perform(put("/activity")
//						.content(asJsonString(new Activity(5, "Lazer show", "For kids and adults", 450.0f)))
//						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(jsonPath("$.charges", is(450.0)));
//	}

//	@Test
//	void shouldDeleteActivity() throws Exception {
//		this.mockMvc.perform(delete("/activity/{id}", 4)).andExpect(status().isOk());
//	}

    /**
     * Ticket booking testing
     */
//    @Test
//    void shouldReturnListOfTicketByCustomerId() throws Exception {
//
//        this.mockMvc.perform(get("/ticket/customer/{id}", 1)).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.[0].ticketId", is(2))).andExpect(jsonPath("$.[0].bill").exists());
//
//    }

//    @Test
//    void shouldReturnChargesOfTicketById() throws Exception {
//
//        this.mockMvc.perform(get("/ticket/bill/{ticketId}/{customerId}", 2, 1)).andDo(print())
//                .andExpect(status().isOk()).andExpect(content().string(containsString("500")));
//    }

//	@Test
//	void shouldDeleteTicketBooking() throws Exception {
//
//		this.mockMvc.perform(delete("/ticket/{id}", 1)).andExpect(status().isOk());
//
//	}

//    public String asJsonString(Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}