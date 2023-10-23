package com.bank.bankaccountservice.repositories;

import com.bank.bankaccountservice.entities.BankAccount;
import com.bank.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
    @RestResource(path="/byAccountType")
    List<BankAccount> findByAccountType(@Param("t") AccountType accountType);


}
