package com.bank.bankaccountservice.entities;

import com.bank.bankaccountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;
    private Date createdAt;
    private Double balence;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
