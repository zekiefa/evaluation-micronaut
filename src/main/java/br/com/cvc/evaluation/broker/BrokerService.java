package br.com.cvc.evaluation.broker;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

import java.util.Set;

import br.com.cvc.evaluation.broker.dto.BrokerHotel;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;

@Client(id = "broker")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/json")
public interface BrokerService {
    @Get("/cities/{codeCity}/hotels")
    HttpResponse<Set<BrokerHotel>> findHotelsByCity(final Integer codeCity);

    @Get("/hotels/{codeHotel}")
    HttpResponse<BrokerHotel> getHotelDetails(final Integer codeHotel);
}
