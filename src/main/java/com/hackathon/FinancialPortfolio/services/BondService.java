package com.hackathon.FinancialPortfolio.services;

import com.hackathon.FinancialPortfolio.entities.Bond;

import java.util.List;

public interface BondService {
    List<Bond> getBonds();
    void addBond(String bondName, String maturityDate, Double interestRate, Double principal);

    void deleteBondByBondName(String bondName);


}
