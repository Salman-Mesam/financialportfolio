package com.hackathon.FinancialPortfolio.services;
import com.fasterxml.jackson.databind.JsonNode;
import com.hackathon.FinancialPortfolio.AlphaVantageClient;
import com.hackathon.FinancialPortfolio.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackathon.FinancialPortfolio.repos.StockRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository dao;

    @Autowired
    private AlphaVantageClient alphaVantageClient;

    @Override
    public List<Stock> getStocks() {
        return dao.findAll();
    }

    @Override
    public Stock getStockInfo(String ticker) {
        return dao.findById(ticker).get();
    }

    @Override
    public void addStock(String ticker, Integer volume) {
        dao.save(new Stock(ticker, volume));
    }

    @Override
    public void updateStockVolume(String ticker, Integer newVolume) {
        Optional<Stock> stock = dao.findById(ticker);
        if (stock.isPresent()) {
            stock.get().setVolume(newVolume);
            dao.save(stock.get());
        }
    }

    // Update stock close price and timestamp
    @Override
    public void updateStockClosePriceTimestamp() {
        List<Stock> stocks = dao.findAll();

        for (Stock stock : stocks) {
            try {
                JsonNode stockData = alphaVantageClient.getStockData(stock.getStockTicker());


                double closePrice = alphaVantageClient.getLatestClosePrice(stockData);
                String timestamp = alphaVantageClient.getLatestTimestamp(stockData);

                stock.setTimestamp(timestamp);
                stock.setClosePrice(closePrice);
                dao.save(stock);

                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteStockByTicker(String ticker) {
        Stock toBeDeleted = dao.findById(ticker).get();
        dao.delete(toBeDeleted);
    }

    public void updateStockClosePriceTimestampTicker(String ticker) {
        Stock stock = dao.findById(ticker).get();

        try {
            JsonNode stockData = alphaVantageClient.getStockData(stock.getStockTicker());


            double closePrice = alphaVantageClient.getLatestClosePrice(stockData);
            String timestamp = alphaVantageClient.getLatestTimestamp(stockData);

            stock.setTimestamp(timestamp);
            stock.setClosePrice(closePrice);
            dao.save(stock);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
