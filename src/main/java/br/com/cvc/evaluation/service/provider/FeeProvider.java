package br.com.cvc.evaluation.service.provider;

import java.math.BigDecimal;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("booking")
public class FeeProvider {

    private BigDecimal fee;

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
