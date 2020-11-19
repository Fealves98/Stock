package com.stockManagement.Stock.web.advice;


import com.stockManagement.Stock.web.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ProductAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorResponse entityNotFoundException(final EntityNotFoundException exception){
        log.error("m=exception, exception=", exception);
        return new ErrorResponse(Collections.singletonList("Informed WareHouse does not exist"));
    }
}
