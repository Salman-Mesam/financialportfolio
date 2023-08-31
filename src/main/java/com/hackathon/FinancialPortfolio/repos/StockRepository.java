package com.hackathon.FinancialPortfolio.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hackathon.FinancialPortfolio.entities.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
}
