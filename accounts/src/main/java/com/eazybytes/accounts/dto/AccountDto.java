package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {
    @Pattern(regexp = "(^$|[0-9]{10})", message = "accountNumber number must be 10 digits")
    private Long accountNumber;
    @NotEmpty(message = "accountType cannot be null or empty")
    private String accountType;
    @NotEmpty(message = "branchAddress cannot be null or empty")
    private String branchAddress;
}
