package com.cg.AmusementPark.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "activity")
public class Activity {

	@Id
	@GeneratedValue(generator = "actSeq")
	@SequenceGenerator(name = "actSeq", sequenceName = "ACTIVITY_SEQ", allocationSize = 1)
	@Column(name = "acitivity_id")
	private Integer activityId;

	@Size(min = 3, max = 40, message = "Activity name should be min 3 characters")
	@Column(name = "activity_name", nullable = false)
	private String activityName;

	@Size(max = 255, message = "Activity name should be min 5 characters")
	@Column(nullable = true)
	private String description;

	@Positive(message = "Activity charges should be greater than 0")
	private float charges;

	@JsonBackReference
	@ManyToMany(mappedBy = "activities", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<TicketBooking> ticketBooking;

	/**
	 * Getters and Setters
	 */
	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCharges() {
		return charges;
	}

	public void setCharges(float charges) {
		this.charges = charges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityId == null) ? 0 : activityId.hashCode());
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
		Activity other = (Activity) obj;
		if (activityId == null) {
			if (other.activityId != null)
				return false;
		} else if (!activityId.equals(other.activityId))
			return false;
		return true;
	}

}