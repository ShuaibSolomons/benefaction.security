package com.benefaction.security.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationErrorResponse {

    private List<ErrorDetails> requestBody;

    private List<HeaderErrors> requestHeader;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ErrorDetails {
        @Schema(
                description = "The name of the field where the error occurred",
                example = "cancellationStateName"
        )
        private String fieldName;

        @Schema(
                description = "Description of the error on the field",
                example = "must not be blank"
        )
        private String message;
    }

    public record HeaderErrors (
            @Schema(
                    description = "The name of the field where the error occurred",
                    example = "header"
            )
            String headerName,

            @Schema(
                    description = "Description of the error on the field",
                    example = "must not be blank"
            )
            String message){
    }
}
