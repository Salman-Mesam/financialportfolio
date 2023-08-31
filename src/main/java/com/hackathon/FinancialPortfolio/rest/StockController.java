package com.hackathon.FinancialPortfolio.rest;

import com.hackathon.FinancialPortfolio.entities.Stock;
import com.hackathon.FinancialPortfolio.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin
public class StockController {
    @Autowired
    private StockService service;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Stock> getStocks(){
        return service.getStocks();
    }
    @GetMapping("/{ticker}")
    public Stock getStockInfo(@PathVariable String ticker){
        return service.getStockInfo(ticker);
    }
    // POST request to add stock using ticker and volume
//    @RequestMapping(method = RequestMethod.POST,value="/add/{ticker}/{volume}")
//    public void addStock(@PathVariable String ticker, @PathVariable Integer volume){
//        service.addStock(ticker, volume);
////        service.updateStockClosePriceTimestamp();
//    }
    // PUT request to update stock volume
//    @RequestMapping(method = RequestMethod.PUT,value="/update/{id}/{newVolume}")
//    public void updateStockVolume(@PathVariable Integer id, @PathVariable Integer newVolume){
//        service.updateStockVolume(id, newVolume);
//    }

    @RequestMapping(method = RequestMethod.PUT,value="/updatePricesAndTimestamp")
    public void updateStockClosePriceTimestamp(){
        service.updateStockClosePriceTimestamp();
    }

//    @RequestMapping(method = RequestMethod.PUT,value="/update/{id}")
//    public void updateStockClosePriceTimestamp(@PathVariable int id){
//        service.updateStockClosePriceTimestampById(id);
//    }

//    @RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
//    public void deleteStockById(@PathVariable Integer id){
//        service.deleteStockById(id);
//    }

    // all the above methods using JSON
    @RequestMapping(method = RequestMethod.POST,value="/add")
    public void addStock(@RequestBody Stock stock){
        service.addStock(stock.getStockTicker(), stock.getVolume());
        service.updateStockClosePriceTimestampTicker(stock.getStockTicker());
    }
    @RequestMapping(method = RequestMethod.PUT,value="/update")
    public void updateStockVolume(@RequestBody Stock stock){
        service.updateStockVolume(stock.getStockTicker(), stock.getVolume());
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/delete")
    public void deleteStockById(@RequestBody Stock stock){
        service.deleteStockByTicker(stock.getStockTicker());
    }

}
