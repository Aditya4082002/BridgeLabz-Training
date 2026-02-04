package lambdaexpressions;

import java.util.*;

class Invoice {
    private String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}


public class InvoiceGenerator {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
            "TXN1001", "TXN1002", "TXN1003"
        );

        // 🔹 Constructor reference
        List<Invoice> invoices = transactionIds.stream()
                                                .map(Invoice::new)
                                                .toList();

        invoices.forEach(System.out::println);
    }
}

