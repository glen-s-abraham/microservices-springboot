package com.eazybytes.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.eazybytes.accounts.dto.CardsDto;

@FeignClient("cards")
public interface CardsFeignclient {
    @GetMapping("/api/fetch")
    public ResponseEntity<CardsDto> fetchCardDetails(
            @RequestHeader String correlationId,
            @RequestParam String mobileNumber);
}
