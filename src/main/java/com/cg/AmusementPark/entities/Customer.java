package com.cg.AmusementPark.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
	@Column(name = "customer_id")
	private Integer customerId;

	@NotBlank(message = "Username is mandatory")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String username;

	@NotBlank(message = "Email is mandatory")
	@Column(unique = true)
	@Email
	private String email;

	@NotBlank(message = "Password is mandatory")
	@Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric with no spaces")
	private String password;

	@Size(max = 1000, message = "Address should have maximum of 1000 characters")
	@Column(nullable = true)
	private String address;

	@Column(nullable = false)
	private String userRole;

	@Size(min = 10, max = 10, message = "Can be of 10 number only")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Can be of 10 number only")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TicketBooking> tickets;

	/**
	 * Customer constructors
	 */
	public Customer() {

	}

	public Customer(Integer customerId,
			@NotBlank(message = "Username is mandatory") @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long") @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces") String username,
			@NotBlank(message = "Email is mandatory") @Email String email,
			@NotBlank(message = "Password is mandatory") @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long") @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric with no spaces") String password,
			@Size(max = 1000, message = "Address should have maximum of 1000 characters") String address,
			String userRole,
			@Size(min = 10, max = 10, message = "Can be of 10 number only") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Can be of 10 number only") String mobileNumber) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.userRole = userRole;
		this.mobileNumber = mobileNumber;
	}

	public Customer(Integer customerId,
			@NotBlank(message = "Username is mandatory") @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long") @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces") String username,
			@NotBlank(message = "Email is mandatory") @Email String email,
			@NotBlank(message = "Password is mandatory") @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long") @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric with no spaces") String password,
			@Size(max = 1000, message = "Address should have maximum of 1000 characters") String address,
			String userRole,
			@Size(min = 10, max = 10, message = "Can be of 10 number only") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Can be of 10 number only") String mobileNumber,
			List<TicketBooking> tickets) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.userRole = userRole;
		this.mobileNumber = mobileNumber;
		this.tickets = tickets;
	}

	/**
	 * Getters and Setters
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
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

	/**
	 * toString() of Customer
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", email=" + email + ", password="
				+ password + ", address=" + address + ", mobileNumber=" + mobileNumber + ", tickets=" + tickets + "]";
	}

}
