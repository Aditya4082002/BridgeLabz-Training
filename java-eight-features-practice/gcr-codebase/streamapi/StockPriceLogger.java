package streamapi;

import java.util.*;
import java.util.stream.*;

public class StockPriceLogger {

    static class StockPrice {
        private String stockName;
        private double price;

        public StockPrice(String stockName, double price) {
            this.stockName = stockName;
            this.price = price;
        }

        public String getStockName() {
            return stockName;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Stock: " + stockName + ", Price: " + price;
        }
    }

    public static void main(String[] args) {

        List<StockPrice> liveFeed = Arrays.asList(
                new StockPrice("TCS", 3890.50),
                new StockPrice("INFY", 1560.75),
                new StockPrice("RELIANCE", 2485.10),
                new StockPrice("HDFCBANK", 1622.30),
                new StockPrice("ITC", 462.80)
        );

        System.out.println("Live Stock Price Updates:\n");

        liveFeed.stream()
                .forEach(stock -> 
                        System.out.println(
                                "Stock: " + stock.getStockName() +
                                " | Price: " + stock.getPrice()
                        )
                );
    }
}
