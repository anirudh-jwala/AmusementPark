package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidActivityException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(InvalidActivityException.class);
    private static final long serialVersionUID = 1L;

    public InvalidActivityException(String message) {
        super(message);
        logger.info(message);
    }

}
