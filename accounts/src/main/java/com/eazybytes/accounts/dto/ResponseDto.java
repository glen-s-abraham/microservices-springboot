package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
    name = "Response",
    description = "ResponseDto"
)
@Data
@AllArgsConstructor
public class ResponseDto {
    @Schema(
        name = "statusCode",
        description = "statusCode",
        example = "200"
    )
    private String statusCode;

    @Schema(
        name = "statusMsg",
        description = "statusMsg",
        example = "Success"
    )
    private String statusMsg;
}
