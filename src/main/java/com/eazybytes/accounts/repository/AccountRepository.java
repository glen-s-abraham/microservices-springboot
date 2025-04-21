package com.eazybytes.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.accounts.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
   
}
