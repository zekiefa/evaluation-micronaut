package br.com.cvc.evaluation.exceptions;

import io.micronaut.http.HttpStatus;

public class HotelNotFoundException extends CustomException {

    public HotelNotFoundException(final String message) {
        super(message, HttpStatus.NOT_FOUND.getCode());
    }
}
