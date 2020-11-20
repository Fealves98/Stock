package com.stockManagement.Stock.web.advice;


import com.stockManagement.Stock.exception.EntityNotFoundException;
import com.stockManagement.Stock.exception.ResourceNotFoundException;
import com.stockManagement.Stock.web.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ProductAdvice {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorResponse entityNotFoundException(final EntityNotFoundException exception) {
        log.error("m=exception, exception=", exception);
        return new ErrorResponse(Collections.singletonList(exception.getMessage()));
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ErrorResponse resourceNotFoundException(final ResourceNotFoundException exception) {
        return new ErrorResponse(Collections.singletonList(exception.getMessage()));
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({JpaSystemException.class})
    public ErrorResponse jpsSystemException(final JpaSystemException exception) {
        return new ErrorResponse(Collections.singletonList(exception.getMessage()));
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ErrorResponse exception(final Exception exception) {
        return new ErrorResponse(Collections.singletonList(exception.getMessage()));
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ErrorResponse methodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        log.error("m=methodArgumentNotValidException, exception=", exception);
        final var errors = new ArrayList<String>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.add(error.getDefaultMessage()));
        return new ErrorResponse(errors);
    }
}
