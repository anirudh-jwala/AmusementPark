package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidCustomerException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(InvalidCustomerException.class);
    private static final long serialVersionUID = 1L;

    public InvalidCustomerException(String message) {
        super(message);
        logger.info(message);
    }

}
