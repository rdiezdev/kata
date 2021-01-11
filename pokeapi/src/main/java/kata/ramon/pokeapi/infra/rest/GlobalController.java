package kata.ramon.pokeapi.infra.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalController {


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestError handleException(ConstraintViolationException exception) {

        Map<String, Collection<String>> errors = extractErrors(exception);

        return  RestError.builder()
                .error("VALIDATION_ERROR")
                .errors(errors)
                .timestamp(LocalDateTime.now()).build();
    }

    private Map<String, Collection<String>> extractErrors(ConstraintViolationException ex) {
        Map<String, Collection<String>> errors = new LinkedHashMap<>();
        ex.getConstraintViolations().forEach(constraintViolation -> {
            String queryParamPath = constraintViolation.getPropertyPath().toString();
            String queryParam = queryParamPath.contains(".") ?
                    queryParamPath.substring(queryParamPath.indexOf(".") + 1) :
                    queryParamPath;
            String errorMessage = constraintViolation.getMessage();
            Collection<String> perQueryParamErrors = errors.getOrDefault(queryParam, new ArrayList<>());
            perQueryParamErrors.add(errorMessage);
            errors.put(queryParam, perQueryParamErrors);
        });
        return errors;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class RestError {
        private final String error;
        private final String message;
        private final Map<String, Collection<String>> errors;
        private final LocalDateTime timestamp;
    }
}
