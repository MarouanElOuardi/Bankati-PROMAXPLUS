package com.bank.bankaccountservice;

import com.bank.bankaccountservice.entities.BankAccount;
import com.bank.bankaccountservice.enums.AccountType;
import com.bank.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository) {
		return args -> {
			for (int i=0; i<10; i++)
			{
				BankAccount bankAccount=BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.balence(1000+Math.random()*9000)
						.accountType(AccountType.valueOf(Math.random()>0.5?"CURRENT_ACCOUNT":"SAVINGS_ACCOUNT"))
						.currency("MAD")
						.createdAt(new java.util.Date())
						.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}

}
