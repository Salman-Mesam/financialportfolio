package com.hackathon.FinancialPortfolio.repos;

import com.hackathon.FinancialPortfolio.entities.Cash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<Cash, String> {
}
