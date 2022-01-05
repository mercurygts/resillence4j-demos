package org.aag.resilencetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResilenceTestApplication {
    private static final Logger logger = LoggerFactory.getLogger(ResilenceTestApplication.class);

    public static void main(String[] args) {
        logger.debug("Starting ResilenceTestApplication");
        SpringApplication.run(ResilenceTestApplication.class, args);
    }

}
