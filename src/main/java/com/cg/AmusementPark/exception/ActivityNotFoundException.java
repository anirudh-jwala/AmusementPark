package com.cg.AmusementPark.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityNotFoundException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(ActivityNotFoundException.class);
    private static final long serialVersionUID = 1L;

    public ActivityNotFoundException(String message) {
        super(message);
        logger.info(message);
    }

}
