package com.bank.bankaccountservice.controllers;

import com.bank.bankaccountservice.entities.BankAccount;
import com.bank.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRESTController {
    private BankAccountRepository bankAccountRepository;
    public AccountRESTController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping(path = "/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(String id) {
        return bankAccountRepository.findById(id).get();
    }


}
