package com.cg.AmusementPark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.AmusementPark.entities.TicketBooking;

@Repository
public interface TicketBookingRepository extends ITicketBookingRepository, JpaRepository<TicketBooking, Integer> {

}
