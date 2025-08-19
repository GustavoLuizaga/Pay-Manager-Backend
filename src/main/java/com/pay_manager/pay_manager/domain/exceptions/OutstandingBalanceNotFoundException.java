package com.pay_manager.pay_manager.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OutstandingBalanceNotFoundException extends RuntimeException {
    public OutstandingBalanceNotFoundException(Long id) {
        super("OutstandingBalance with id" + id +" not found");
    }
}
