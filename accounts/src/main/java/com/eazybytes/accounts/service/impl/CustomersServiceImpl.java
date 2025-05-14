package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.dto.AccountDto;
import com.eazybytes.accounts.dto.CardsDto;
import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.dto.LoansDto;
import com.eazybytes.accounts.entity.Account;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.ICustomerService;
import com.eazybytes.accounts.service.client.CardsFeignclient;
import com.eazybytes.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomerService {

        private AccountRepository accountsRepository;
        private CustomerRepository customerRepository;
        private CardsFeignclient cardsFeignClient;
        private LoansFeignClient loansFeignClient;

        /**
         * @param mobileNumber - Input Mobile Number
         * @return Customer Details based on a given mobileNumber
         */
        @Override
        public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
                Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
                Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                                () -> new ResourceNotFoundException("Account", "customerId",
                                                customer.getCustomerId().toString()));

                CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer,
                                new CustomerDetailsDto());
                customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountDto()));

                ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
                customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

                ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
                customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

                return customerDetailsDto;

        }
}