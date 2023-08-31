package com.hackathon.FinancialPortfolio.services;

import com.hackathon.FinancialPortfolio.entities.Stock;

import java.util.List;
public interface StockService {
    List<Stock> getStocks();
    Stock getStockInfo(String ticker);
    void addStock(String ticker, Integer volume);
    void updateStockVolume(String ticker, Integer newVolume);

    void updateStockClosePriceTimestamp();

    void deleteStockByTicker(String ticker);
    void updateStockClosePriceTimestampTicker(String ticker);

}
