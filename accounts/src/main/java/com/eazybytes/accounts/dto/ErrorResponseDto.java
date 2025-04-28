package com.eazybytes.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "ErrorResponse", description = "ErrorResponseDto")
@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(name = "apiPath", description = "apiPath")
    private String apiPath;

    @Schema(name = "errorCode", description = "errorCode")
    private HttpStatus errorCode;

    @Schema(name = "errorMessage", description = "errorMessage")
    private String errorMessage;

    @Schema(name = "errorTime", description = "errorTime")
    private LocalDateTime errorTime;
}
