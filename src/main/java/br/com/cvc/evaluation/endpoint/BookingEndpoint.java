package br.com.cvc.evaluation.endpoint;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.cvc.evaluation.domain.Hotel;
import br.com.cvc.evaluation.service.BookingService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

@Controller("/api/v1/booking")
public class BookingEndpoint {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private final BookingService bookingService;

    @Inject
    public BookingEndpoint(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Get("/{cityCode}/{checkin}/{checkout}/{adults}/{children}")
    @Produces(MediaType.APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.BLOCKING)
    public HttpResponse<List<Hotel>> find(@PathVariable("cityCode") final Integer cityCode,
                    @PathVariable("checkin") final String checkin,
                    @PathVariable("checkout") final String checkout,
                    @PathVariable("adults") final Integer adults,
                    @PathVariable("children") final Integer children) {

        final var hotels = this.bookingService.findHotels(cityCode, this.parseDate(checkin), this.parseDate(checkout), adults,
                        children);

        return HttpResponse.ok(hotels);
    }

    private LocalDate parseDate(final String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
