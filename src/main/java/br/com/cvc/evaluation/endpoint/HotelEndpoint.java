package br.com.cvc.evaluation.endpoint;

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

@Controller("/api/v1/hotels")
public class HotelEndpoint {
    private final BookingService bookingService;

    @Inject
    public HotelEndpoint(final BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.BLOCKING)
    public HttpResponse<Hotel> find(@PathVariable("id") final Integer id) {
        final var hotel = this.bookingService.getHotelDetails(id);

        if (hotel.isPresent()) {
            return HttpResponse.ok(hotel.get());
        }

        return HttpResponse.notFound();
    }
}
