package com.hackathon.FinancialPortfolio.controller;

import com.hackathon.FinancialPortfolio.entities.Bond;
import com.hackathon.FinancialPortfolio.entities.Stock;
import com.hackathon.FinancialPortfolio.rest.BondController;
import com.hackathon.FinancialPortfolio.services.BondService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestBondControllerUnitTest.Config.class)
public class TestBondControllerUnitTest {
    protected static class Config {
        @Bean
        public BondService service() {
            Bond bond = new Bond();
            bond.setBondName("US Treasury Note");
            bond.setInterestRate(1.75);
            List<Bond> bonds = new ArrayList<>();
            bonds.add(bond);

            BondService service = mock(BondService.class);
            when(service.getBonds()).thenReturn(bonds);
            return service;
        }

        @Bean
        public BondController controller() {
            return new BondController();
        }
    }
    @Autowired
    private BondController bondController;

    @Test
    public void testFindAll(){
        List<Bond> bonds = bondController.getBonds();
        assertEquals(bonds.size(),1);
    }

    @Test
    public void testBondInterestRate(){
        List<Bond> bonds = bondController.getBonds();
        assertEquals(bonds.get(0).getInterestRate(),1.75);
    }

}
