package com.benefaction.security.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorHandlingResponse {

    @Schema(
            description = "The timestamp of the error",
            example = "1699436654342"
    )
    private Date timestamp;

    @Schema(
            description = "The HTTP status code.",
            example = "400"
    )
    private Integer status;

    @Schema(
            description = "The HTTP status code reason phrase.",
            example = "Bad Request"
    )
    private String error;

    @JsonIgnore
    private String exception;

    @Schema(
            description = "The resource URL that was requested.",
            example = "/criterion"
    )
    private String path;

    @ArraySchema(
            arraySchema = @Schema(
                    example = "[{\"fieldName\":\"cancellationState\", \"message\":\"must not be blank\"}]",
                    description = "Details of errors which needs to be fixed."
            )
    )
    private ValidationErrorResponse errors;
}

