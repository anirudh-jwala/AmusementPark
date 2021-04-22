package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidTicketBookingException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(InvalidTicketBookingException.class);
    private static final long serialVersionUID = 1L;

    public InvalidTicketBookingException(String message) {
        super(message);
        logger.info(message);
    }

}
