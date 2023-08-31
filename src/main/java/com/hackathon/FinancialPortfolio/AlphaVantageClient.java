package com.hackathon.FinancialPortfolio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Class for Financial API: Alpha Vantage to retrieve real-time data
 */
@Service
public class AlphaVantageClient {

    private static final String BASE_URL = "https://www.alphavantage.co/query";
    private static final String API_KEY = "TCJULOFXKBKDJK1T"; // API key from Alpha Vantage

    public JsonNode getStockData(String symbol) throws Exception{
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(BASE_URL + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=1min&apikey=" + API_KEY);

        HttpResponse response = httpClient.execute(request);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(result.toString());

    }

    // Get the latest stock info, including time, open, high, low, close price, and volume
    public JsonNode getLatestQuote(JsonNode stockData){
        JsonNode timeSeriesData = stockData.get("Time Series (1min)");
        String latestTime = timeSeriesData.fieldNames().next();
        return timeSeriesData.get(latestTime);
    }

    public double getLatestClosePrice(JsonNode stockData){
        JsonNode latestQuote = getLatestQuote(stockData);
        return latestQuote.get("4. close").asDouble();
    }

    public int getLatestVolume(JsonNode stockData){
        JsonNode latestQuote = getLatestQuote(stockData);
        return latestQuote.get("5. volume").asInt();
    }

    public String getLatestTimestamp(JsonNode stockData){
        JsonNode timeSeriesData = stockData.get("Time Series (1min)");
        return timeSeriesData.fieldNames().next();
    }








    public static void main(String[] args) throws Exception {
        AlphaVantageClient client = new AlphaVantageClient();
        JsonNode data = client.getStockData("AAPL");

        System.out.println("Latest close price: $" + client.getLatestClosePrice(data));
        System.out.println("Latest volume: " + client.getLatestVolume(data));
        System.out.println("Latest timestamp: " + client.getLatestTimestamp(data));
    }
}
