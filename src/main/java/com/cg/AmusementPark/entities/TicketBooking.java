package com.cg.AmusementPark.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "ticket_booking")
public class TicketBooking {

	@Id
	@GeneratedValue(generator = "ticketSequence")
	@SequenceGenerator(name = "ticketSequence", sequenceName = "TICKET_SEQ", allocationSize = 1, initialValue = 1000)
	private Integer ticketId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date")
	private LocalDate date;

	@Positive(message = "Bill amount should be greater than 0")
	private float bill;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Activity> activities;

	/**
	 * Ticket booking constructor
	 */
	public TicketBooking() {

	}

	public TicketBooking(Integer ticketId, LocalDate date, float bill) {
		this.ticketId = ticketId;
		this.date = date;
		this.bill = bill;
	}

	public TicketBooking(Integer ticketId, LocalDate date, float bill, Customer customer) {
		this.ticketId = ticketId;
		this.date = date;
		this.bill = bill;
		this.customer = customer;
	}

	public TicketBooking(Integer ticketId, LocalDate date, float bill, Customer customer, List<Activity> activities) {
		this.ticketId = ticketId;
		this.date = date;
		this.bill = bill;
		this.customer = customer;
		this.activities = activities;
	}

	/**
	 * Getters and Setters
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
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
		TicketBooking other = (TicketBooking) obj;
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
		return true;
	}

}