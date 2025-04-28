package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
    name = "Customer",
    description = "Customer details"
)
public class CustomerDto {
   
    @Schema(
        name = "name",
        description = "Customer name",
        example = "John Doe"
    )
    @NotEmpty(message = "name cannot be null or empty")
    @Size(min = 5,max = 30)
    private String name;

    @Schema(
        name = "email",
        description = "Customer email address",
        example = "B9m9o@example.com"
    )
    @NotEmpty(message = "email cannot be null or empty")
    @Email(message = "invalid email address")
    private String email;

    @Schema(
        name = "mobileNumber",
        description = "Customer mobile number",
        example = "1234567890"
    )
    @NotEmpty(message = "mobileNumber cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountDto accountDto;
}
