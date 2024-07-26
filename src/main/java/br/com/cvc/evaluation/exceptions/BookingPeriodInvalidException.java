package br.com.cvc.evaluation.exceptions;

import io.micronaut.http.HttpStatus;

public class BookingPeriodInvalidException extends CustomException {
    public BookingPeriodInvalidException(final String message) {
        super(message, HttpStatus.BAD_REQUEST.getCode());
    }
}
