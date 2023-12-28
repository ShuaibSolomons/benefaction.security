package com.benefaction.security.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.client.ClientHttpResponse;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseRuntimeException extends RuntimeException {

    private String message;
    private String path;
    private Throwable cause;
    private ClientHttpResponse httpResponse;
    private Object response;

    //Message can be retrieved using this accessor method
    @Override
    public String getMessage() {
        return message;
    }

    //Message can be retrieved using this accessor method
    public String getPath() {
        return path;
    }

    //Message can be retrieved using this accessor method
    @Override
    public Throwable getCause() {
        return cause;
    }

    public Object getResponse() {
        return response;
    }

    protected BaseRuntimeException(String message) {
        this.message = message;
    }

    protected BaseRuntimeException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    protected BaseRuntimeException(String message, ClientHttpResponse httpResponse) {
        this.message = message;
        this.httpResponse = httpResponse;
    }

    protected BaseRuntimeException(String message, Object response) {
        this.message = message;
        this.response = response;
    }

    protected BaseRuntimeException(String message, String path) {
        this.path = path;
        this.message = message;
    }
}

