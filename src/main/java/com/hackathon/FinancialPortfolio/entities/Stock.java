package com.hackathon.FinancialPortfolio.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
//import javax.persistence.*;
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    @Id
    @Column(name="stock_ticker")
    private String stockTicker;
    @Column(name="volume")
    private Integer volume;

    @Column(name = "close_price")
    private Double closePrice;

    @Column(name = "time_stamp")
    private String timestamp;

    public Stock(){}
    public Stock(String stockTicker, Integer volume) {
        this.stockTicker = stockTicker;
        this.volume = volume;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
