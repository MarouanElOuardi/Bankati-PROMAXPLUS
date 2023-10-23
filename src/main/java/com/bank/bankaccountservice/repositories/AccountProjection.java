package com.bank.bankaccountservice.repositories;

import com.bank.bankaccountservice.entities.BankAccount;
import com.bank.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types= BankAccount.class, name="p1")
public interface AccountProjection {
    public Double getId();
    public double getBalence();
    public AccountType getAccountType();

}
