package org.aag.resilencetest.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.aag.resilencetest.exceptions.RetryableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    private int counter = 0;

    @GetMapping("/retry")
    @Retry(name = "trajano", fallbackMethod = "fallback")
    public String retry() throws RetryableException {
        counter++;
        throw new RetryableException("Retryable exception jut to test Retry annotation");
    }

    private String fallback(RetryableException e) {
        return "Gracile response of retry final error after " + counter + " retrys";
    }
}
