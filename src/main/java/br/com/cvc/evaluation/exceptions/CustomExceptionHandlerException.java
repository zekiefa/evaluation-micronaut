package br.com.cvc.evaluation.exceptions;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.server.exceptions.response.ErrorContext;
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {CustomException.class, ExceptionHandler.class})
public class CustomExceptionHandlerException implements ExceptionHandler<CustomException, HttpResponse> {
    private final ErrorResponseProcessor<?> errorResponseProcessor;

    public CustomExceptionHandlerException(final ErrorResponseProcessor<?> errorResponseProcessor) {
        this.errorResponseProcessor = errorResponseProcessor;
    }

    @Override
    public HttpResponse handle(final HttpRequest request, final CustomException exception) {
        return errorResponseProcessor.processResponse(ErrorContext.builder(request)
                                        .cause(exception)
                                        .errorMessage(exception.getMessage())
                        .build(), HttpResponse.status(HttpStatus
                        .valueOf(exception.getStatus())));
    }
}
