package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerExistsException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(CustomerExistsException.class);
    private static final long serialVersionUID = 1L;

    public CustomerExistsException(String message) {
        super(message);
        logger.info(message);
    }

}
