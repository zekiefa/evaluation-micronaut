package br.com.cvc.evaluation.service;

import java.math.BigDecimal;

import br.com.cvc.evaluation.service.provider.FeeProvider;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeeService {
    private static final Logger log = LoggerFactory.getLogger(FeeService.class);

    private final FeeProvider provider;

    @Inject
    public FeeService(final FeeProvider provider) {
        this.provider = provider;
    }

    public BigDecimal calculateFee(final BigDecimal paxPrice, final Long days) {
        log.info("Calculating fee: pax price {} for {} days", paxPrice, days);
        final var totalPricePax = paxPrice.multiply(BigDecimal.valueOf(days));
        final var fee = totalPricePax.multiply(this.provider.getFee());

        log.info("Fee calculated: {}", fee);
        return fee;
    }
}
