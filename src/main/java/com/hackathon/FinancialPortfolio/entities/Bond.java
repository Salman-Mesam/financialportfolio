package com.hackathon.FinancialPortfolio.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "bond")
public class Bond implements Serializable {
    @Id
    @Column(name="bond_name")
    private String bondName;
    @Column(name="maturity_date")
    private String maturityDate;
    @Column(name="interest_rate")
    private Double interestRate;
    @Column(name="principal")
    private Double principal;
    public Bond() {
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Bond(String bondName, String maturityDate, Double interestRate, Double principal) {
        this.bondName = bondName;
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
        this.principal = principal;
    }


    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
