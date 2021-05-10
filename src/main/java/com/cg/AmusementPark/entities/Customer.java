package com.cg.AmusementPark.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(generator = "customerSequence")
	@SequenceGenerator(name = "customerSequence", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
	private Long customerId;

	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String username;

	@Column(unique = true)
	@Email
	private String email;

	@Column(length = 3000)
	private String password;

	@Size(max = 1000, message = "Address should have maximum of 1000 characters")
	@Column(nullable = true)
	private String address;

	@Size(min = 10, max = 10, message = "Can be of 10 number only")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Can be of 10 number only")
	private String mobileNumber;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TicketBooking> tickets;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "customer_roles", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * Customer constructors
	 */
	public Customer() {

	}

	public Customer(Long customerId, String username, String email, String password) {
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Customer(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Customer(String username, String email, String password, String address, String mobileNumber) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public Customer(Long customerId, String username, String email, String password, String address,
			String mobileNumber) {
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public Customer(Long customerId, String username, String email, String password, String address,
			String mobileNumber, List<TicketBooking> tickets) {
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.tickets = tickets;
	}

	public Customer(Long customerId, String username, String email, String password, String address,
			String mobileNumber, List<TicketBooking> tickets, Set<Role> roles) {
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.tickets = tickets;
		this.roles = roles;
	}

	/**
	 * Getters and Setters
	 */
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<TicketBooking> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketBooking> tickets) {
		this.tickets = tickets;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

}
