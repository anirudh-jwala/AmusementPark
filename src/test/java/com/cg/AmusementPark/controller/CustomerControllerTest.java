package com.cg.AmusementPark.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.cg.AmusementPark.AmusementParkApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmusementParkApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldCheckCustomerEmail() throws Exception {
		this.mockMvc
				.perform(get("/customer/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("email", is("sanjay@gmail.com")));
	}

}
