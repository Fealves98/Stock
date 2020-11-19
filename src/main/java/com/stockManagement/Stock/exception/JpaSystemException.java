package com.stockManagement.Stock.exception;

import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class JpaSystemException extends HystrixBadRequestException implements ExceptionNotWrappedByHystrix {

    public JpaSystemException(String message) {
        super(message);
    }

    public JpaSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
