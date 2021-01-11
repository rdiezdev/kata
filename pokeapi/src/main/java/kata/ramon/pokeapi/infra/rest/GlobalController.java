package kata.ramon.pokeapi.infra.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalController {


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestError handleException(ConstraintViolationException exception) {
        return  RestError.builder()
                .error("VALIDATION_ERROR")
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected RestError handleException(Exception exception) {
        return  RestError.builder()
                .error("INTERNAL_ERROR")
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now()).build();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestError handleNoHandlerFound(NoHandlerFoundException exception) {
        return RestError.builder()
                .error("RESOURCE_NOT_FOUND")
                .message("Resource not found")
                .timestamp(LocalDateTime.now()).build();
    }

    @Builder
    @RequiredArgsConstructor
    @Getter
    public static class RestError {
        private final String error;
        private final String message;
        private final LocalDateTime timestamp;
    }
}
