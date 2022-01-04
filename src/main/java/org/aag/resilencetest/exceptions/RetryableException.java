package org.aag.resilencetest.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryableException extends Exception{

    private static final Logger logger = LoggerFactory.getLogger(RetryableException.class);

    public RetryableException(String message){
        super(message);
        logger.error(message);

    }
}
