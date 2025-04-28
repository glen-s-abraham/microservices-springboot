package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Account", description = "Account details")
public class AccountDto {
    @Schema(name = "accountNumber", description = "Account number")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "accountNumber number must be 10 digits")
    private Long accountNumber;

    @Schema(name = "accountType", description = "Account type", example = "savings")
    @NotEmpty(message = "accountType cannot be null or empty")
    private String accountType;

    @Schema(name = "branchAddress", description = "Branch address", example = "Pune")
    @NotEmpty(message = "branchAddress cannot be null or empty")
    private String branchAddress;
}
