package com.hackathon.FinancialPortfolio.services;

import com.hackathon.FinancialPortfolio.entities.Cash;

import java.util.List;

public interface CashService {
    List<Cash> getCash();
    void addAccount(String bankName, Double amount, String currency);
    void updateAmountByBankName(String bankName, Double amount);
    void deleteAccountByBankName(String bankName);
}
