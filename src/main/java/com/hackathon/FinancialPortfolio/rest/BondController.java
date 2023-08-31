package com.hackathon.FinancialPortfolio.rest;

import com.hackathon.FinancialPortfolio.entities.Bond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackathon.FinancialPortfolio.services.BondService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonds")
@CrossOrigin
public class BondController {
    @Autowired
    private BondService service;
    @GetMapping
    public List<Bond> getBonds(){
        return service.getBonds();
    }
//    @RequestMapping(method = RequestMethod.POST,value="/add/{bondName}/{maturityDate}/{interestRate}/{principal}")
//    public void addBond(@PathVariable String bondName, @PathVariable String maturityDate, @PathVariable Double interestRate, @PathVariable Double principal){
//        service.addBond(bondName, maturityDate, interestRate, principal);
//    }
    // add bond using JSON
    @RequestMapping(method = RequestMethod.POST,value="/add")
    public void addBond(@RequestBody Bond bond){
        service.addBond(bond.getBondName(), bond.getMaturityDate(), bond.getInterestRate(), bond.getPrincipal());
    }

//    @RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
//    public void deleteBondById(@PathVariable Integer id){
//        service.deleteBondById(id);
//    }
    // delete bond using JSON
    @RequestMapping(method = RequestMethod.DELETE,value="/delete")
    public void deleteBondById(@RequestBody Bond bond){
        service.deleteBondByBondName(bond.getBondName());
    }
}
