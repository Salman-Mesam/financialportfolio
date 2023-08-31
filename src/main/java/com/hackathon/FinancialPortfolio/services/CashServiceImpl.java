package com.hackathon.FinancialPortfolio.services;

import com.hackathon.FinancialPortfolio.entities.Cash;
import com.hackathon.FinancialPortfolio.repos.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashServiceImpl implements CashService{
    @Autowired
    private CashRepository dao;

    @Override
    public List<Cash> getCash() {
        return dao.findAll();
    }

    @Override
    public void addAccount(String bankName, Double amount, String currency) {
        dao.save(new Cash(bankName, amount, currency));
    }

    @Override
    public void updateAmountByBankName(String bankName, Double amount) {
        Cash cash = dao.findById(bankName).get();
        cash.setCashAmount(amount);
        dao.save(cash);
    }

    @Override
    public void deleteAccountByBankName(String bankName) {
        dao.deleteById(bankName);
    }
}
