package com.hackathon.FinancialPortfolio.services;

import com.hackathon.FinancialPortfolio.entities.Bond;
import com.hackathon.FinancialPortfolio.repos.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondServiceImpl implements BondService {
    @Autowired
    private BondRepository dao;

    @Override
    public List<Bond> getBonds() {
        return dao.findAll();
    }

    @Override
    public void addBond(String bondName, String maturityDate, Double interestRate, Double principal) {
        dao.save(new Bond(bondName, maturityDate, interestRate, principal));
    }

    @Override
    public void deleteBondByBondName(String bondName) {
        dao.deleteById(bondName);
    }
}
