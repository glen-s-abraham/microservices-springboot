package com.eazybytes.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
	info=@Info(
		title = "Accounts microservice REST API documentation",
		description = "Eazybank Accounts microservice REST API Documentation",
		version = "v1",
		contact = @Contact(
			name = "Glen",
			email = "glen@gmail.com"
		),
		license = @License(
			name = "Apache 2,0",
			url = "https://www.apache.org/licenses/LICENSE-2.0"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Eazybank documentation",
		url = "https://eazybytes.com"
	)	
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
