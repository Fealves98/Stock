package com.stockManagement.Stock.exception;

import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class ConstraintViolationException extends HystrixBadRequestException implements ExceptionNotWrappedByHystrix {

    public ConstraintViolationException(String message) {
        super(message);
    }

    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
