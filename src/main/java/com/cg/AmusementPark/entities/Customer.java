package com.cg.AmusementPark.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(generator = "custSeq")
	@SequenceGenerator(name = "custSeq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
	@Column(name = "customer_id")
	private Integer customerId;

	@NotBlank(message = "Username is mandatory")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
	@Pattern(regexp = "^[a-zA-z0-9]+$", message = "Username must be alphanumeric with no spaces")
	@Column(unique = true)
	private String username;

	@NotBlank(message = "Email is mandatory")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email should be valid")
	private String email;

	@NotBlank(message = "Password is mandatory")
	@Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric with no spaces")
	private String password;

	@Column(nullable = true)
	private String address;

	@Pattern(regexp = "^[0-9]+$", message = "Phone must be numeric")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@OneToMany(mappedBy = "customer", targetEntity = TicketBooking.class)
	private List<TicketBooking> tickets;

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

}
