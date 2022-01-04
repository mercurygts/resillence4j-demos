package org.aag.resilencetest.service;

import org.aag.resilencetest.exceptions.RetryableException;

public interface RetryableService {

    public String helloWorld() throws RetryableException;

}
