package com.hackathon.FinancialPortfolio.controller;
import com.hackathon.FinancialPortfolio.entities.Cash;
import com.hackathon.FinancialPortfolio.rest.CashController;
import com.hackathon.FinancialPortfolio.services.CashService;
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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestCashControllerUnitTest.Config.class)
public class TestCashControllerUnitTest {
    protected static class Config {

        @Bean
        public CashService service() {
            Cash cash = new Cash();
            cash.setBankName("BOA");
            cash.setCashAmount(123.0);
            List<Cash> cashs = new ArrayList<>();
            cashs.add(cash);

            CashService service = mock(CashService.class);
            when(service.getCash()).thenReturn(cashs);
            return service;
        }

        @Bean
        public CashController controller() {
            return new CashController();
        }
    }

    @Autowired
    private CashController cashController;

    @Test
    public void testFindAll(){
        List<Cash> cashs = cashController.getCash();
        assertEquals(cashs.size(),1);
    }
    @Test
    public void testCashById(){
        Cash cash = cashController.getCash().get(0);
        assertEquals(cash.getCashAmount(),123);
    }
}
