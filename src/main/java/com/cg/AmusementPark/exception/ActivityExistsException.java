package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityExistsException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(ActivityExistsException.class);
    private static final long serialVersionUID = 1L;

    public ActivityExistsException(String message) {
        super(message);
        logger.info(message);
    }

}
