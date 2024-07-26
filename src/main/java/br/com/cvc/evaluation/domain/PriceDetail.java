package br.com.cvc.evaluation.domain;

import java.math.BigDecimal;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record PriceDetail(BigDecimal pricePerDayAdult, BigDecimal pricePerDayChild) {

}
