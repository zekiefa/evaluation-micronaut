package br.com.cvc.evaluation.domain;

import java.math.BigDecimal;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Room(Integer roomID, String categoryName, BigDecimal totalPrice, PriceDetail priceDetail) {

}
