package com.hackathon.FinancialPortfolio.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cash")
public class Cash implements Serializable {
    @Id
    @Column(name="bank_name")
    private String bankName;
    @Column(name="cash_amount")
    private Double cashAmount;
    @Column(name="currency")
    private String currency;

    public Cash(String bankName, Double cashAmount, String currency) {
        this.bankName = bankName;
        this.cashAmount = cashAmount;
        this.currency = currency;
    }

    public Cash() {
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
