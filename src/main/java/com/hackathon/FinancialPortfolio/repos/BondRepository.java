package com.hackathon.FinancialPortfolio.repos;

import com.hackathon.FinancialPortfolio.entities.Bond;
import com.hackathon.FinancialPortfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BondRepository extends JpaRepository<Bond, String> {
}
