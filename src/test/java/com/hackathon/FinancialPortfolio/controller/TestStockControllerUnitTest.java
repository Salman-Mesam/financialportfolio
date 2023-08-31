package com.hackathon.FinancialPortfolio.controller;

import com.hackathon.FinancialPortfolio.entities.Stock;
import com.hackathon.FinancialPortfolio.rest.StockController;
import com.hackathon.FinancialPortfolio.services.StockService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestStockControllerUnitTest.Config.class)
public class TestStockControllerUnitTest {
    protected static class Config {

        @Bean
        public StockService service() {
            Stock stock = new Stock();
            stock.setStockTicker("MSFT");
            stock.setVolume(123);
            List<Stock> stocks = new ArrayList<>();
            stocks.add(stock);

            StockService service = mock(StockService.class);
            when(service.getStocks()).thenReturn(stocks);
            when(service.getStockInfo("MSFT")).thenReturn(stock);
            return service;
        }

        @Bean
        public StockController controller() {
            return new StockController();
        }
    }
    @Autowired
    private StockController stockController;

    @Test
    public void testFindAll(){
        List<Stock> stocks = stockController.getStocks();
        assertEquals(stocks.size(),1);
    }
    @Test
    public void testStockById(){
        Stock stock = stockController.getStockInfo("MSFT");
        assertEquals(stock.getVolume(),123);
    }

}
