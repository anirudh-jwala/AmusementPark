package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketBookingNotFoundException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(TicketBookingNotFoundException.class);
    private static final long serialVersionUID = 1L;

    public TicketBookingNotFoundException(String message) {
        super(message);
        logger.info(message);
    }

}
