package com.bank.bankaccountservice.controllers;

import com.bank.bankaccountservice.entities.BankAccount;
import com.bank.bankaccountservice.enums.AccountType;
import com.bank.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/bank")
public class AccountRESTController {
    private BankAccountRepository bankAccountRepository;
    public AccountRESTController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping(path = "/bankAccounts/all")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(String id) {
        return bankAccountRepository.findById(id).get();
    }
    @PostMapping("/bankAccounts/create")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("/bankAccounts/update/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount, @PathVariable String id) {
        BankAccount account=bankAccountRepository.findById(id).get();
        if(bankAccount.getBalence()!=null) account.setBalence(bankAccount.getBalence());
        if(bankAccount.getAccountType()!=null) account.setAccountType(bankAccount.getAccountType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getCreatedAt()!=null) account.setCreatedAt(bankAccount.getCreatedAt());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/delete/{id}")
    public BankAccount delete(@PathVariable String id) {
        BankAccount account=bankAccountRepository.findById(id).get();
        bankAccountRepository.deleteById(id);
        return account;
    }
    @GetMapping("/bankAccounts/search/accountType")
    public List<BankAccount> searchByAccountType(@RequestParam(name = "accountType") String accountType) {
        return bankAccountRepository.findByAccountType(AccountType.valueOf(accountType));
    }



}
