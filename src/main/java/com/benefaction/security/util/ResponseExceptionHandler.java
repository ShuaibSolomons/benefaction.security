package com.benefaction.security.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ResponseExceptionHandler {

    @ExceptionHandler({ResponseException.UserAlreadyCreated.class})
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> handleUserAlreadyCreatedException(ResponseException.UserAlreadyCreated e, HttpServletRequest request) {
        log.warn(e.getClass().getSimpleName() + ": " + e.getMessage());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ErrorHandlingResponse errorResponse = createErrorResponse.apply(e, request);

        ValidationErrorResponse.ErrorDetails error = new ValidationErrorResponse.ErrorDetails("email", e.getMessage());

        List<ValidationErrorResponse.ErrorDetails> errorDetails = new ArrayList<>();
        errorDetails.add(error);

        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        validationErrorResponse.setRequestBody(errorDetails);

        errorResponse.setErrors(validationErrorResponse);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(header)
                .body(errorResponse);
    }

    private static final BiFunction<Exception, HttpServletRequest, ErrorHandlingResponse> createErrorResponse = (ex, request) -> {
        ErrorHandlingResponse errorResponse = new ErrorHandlingResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setException(ex.getClass().getName());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        return errorResponse;
    };
}
