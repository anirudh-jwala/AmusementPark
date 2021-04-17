package com.cg.AmusementPark.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cg.AmusementPark.AmusementParkApplication;
import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmusementParkApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void shouldRetieveAllCustomers() throws CustomerNotFoundException {

		when(customerRepository.findAll())
				.thenReturn(Stream.of(new Customer(1, "sanjay", "sanjay@gmail.com", "sanjay", "Pune", "9848012345"))
						.collect(Collectors.toList()));

		assertEquals(1, customerService.viewCustomers().size());

	}

}
