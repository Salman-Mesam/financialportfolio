package com.hackathon.FinancialPortfolio.rest;

import com.hackathon.FinancialPortfolio.entities.Cash;
import com.hackathon.FinancialPortfolio.services.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cash")
@CrossOrigin
public class CashController {
    @Autowired
    private CashService service;
    @GetMapping
    public List<Cash> getCash(){
        return service.getCash();
    }

//    @RequestMapping(method = RequestMethod.POST,value="/add/{bankName}/{amount}/{currency}")
//    public void addAccount(@PathVariable String bankName, @PathVariable Double amount, @PathVariable String currency){
//        service.addAccount(bankName, amount, currency);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT,value="/update/{id}/{newAmount}")
//    public void updateAmountById(@PathVariable Integer id, @PathVariable Double newAmount){
//        service.updateAmountById(id, newAmount);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
//    public void deleteAccountById(@PathVariable Integer id){
//        service.deleteAccountById(id);
//    }

    // all the above methods using JSON
    @RequestMapping(method = RequestMethod.POST,value="/add")
    public void addAccount(@RequestBody Cash cash){
        service.addAccount(cash.getBankName(), cash.getCashAmount(), cash.getCurrency());
    }
    @RequestMapping(method = RequestMethod.PUT,value="/update")
    public void updateAmountById(@RequestBody Cash cash){
        service.updateAmountByBankName(cash.getBankName(), cash.getCashAmount());
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/delete")
    public void deleteAccountById(@RequestBody Cash cash){
        service.deleteAccountByBankName(cash.getBankName());
    }
}





