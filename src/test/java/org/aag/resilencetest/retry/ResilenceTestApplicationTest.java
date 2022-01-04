package org.aag.resilencetest.retry;

import io.github.resilience4j.retry.Retry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.aag.resilencetest.exceptions.RetryableException;
import org.aag.resilencetest.service.RetryableService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResilenceTestApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ResilenceTestApplicationTest.class);

    @Test
    public void testMain() throws RetryableException {
        // Instanciamos el servicio retryableService minimo a modo de traza
        RetryableService retryableService = new RetryableService() {
            @Override
            public String helloWorld() throws RetryableException {
                logger.debug("trying to Hello the World");
                throw new RetryableException("Exception in Retry service");
            }
        };

        // Creamos un servicio de retry con la configuracion por defecto
        Retry retry = Retry.ofDefaults("id");
        // Y asociamos este retry al servicio retryableService
        CheckedFunction0<String> retryableSupplier = Retry
                .decorateCheckedSupplier(retry, retryableService::helloWorld);

        // Invocamos el servicio retryableService
        Try<String> result = Try.of(retryableSupplier)
            .recover((throwable) -> {
                logger.error("A retryable exception occurred:"+throwable.getMessage());
                return "Hello world from recovery function";
            });

        assertEquals(result.get(),"Hello world from recovery function");
    }
}