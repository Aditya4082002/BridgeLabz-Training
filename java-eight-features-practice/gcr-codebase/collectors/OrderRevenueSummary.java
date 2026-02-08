package collectors;

import java.util.*;
import java.util.stream.*;

public class OrderRevenueSummary {

    static class Order {
        private String customerName;
        private double orderTotal;

        public Order(String customerName, double orderTotal) {
            this.customerName = customerName;
            this.orderTotal = orderTotal;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getOrderTotal() {
            return orderTotal;
        }
    }

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("Rahul", 2500.50),
                new Order("Sneha", 1800.00),
                new Order("Rahul", 3200.75),
                new Order("Aman", 950.25),
                new Order("Sneha", 2200.40),
                new Order("Rahul", 1500.00)
        );

        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getOrderTotal)
                ));

        System.out.println("Order Revenue Summary:\n");

        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " : " + total)
        );
    }
}
