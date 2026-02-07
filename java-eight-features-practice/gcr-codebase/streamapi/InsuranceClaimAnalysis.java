package streamapi;

import java.util.*;
import java.util.stream.*;

public class InsuranceClaimAnalysis {

    static class InsuranceClaim {
        private String claimId;
        private String claimType;
        private double claimAmount;

        public InsuranceClaim(String claimId, String claimType, double claimAmount) {
            this.claimId = claimId;
            this.claimType = claimType;
            this.claimAmount = claimAmount;
        }

        public String getClaimId() {
            return claimId;
        }

        public String getClaimType() {
            return claimType;
        }

        public double getClaimAmount() {
            return claimAmount;
        }
    }

    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("C101", "Health", 50000),
                new InsuranceClaim("C102", "Vehicle", 20000),
                new InsuranceClaim("C103", "Health", 75000),
                new InsuranceClaim("C104", "Property", 100000),
                new InsuranceClaim("C105", "Vehicle", 30000),
                new InsuranceClaim("C106", "Health", 60000),
                new InsuranceClaim("C107", "Property", 150000)
        );

        Map<String, Double> averageByType = claims.stream()
                .collect(Collectors.groupingBy(InsuranceClaim::getClaimType,
                        Collectors.averagingDouble(InsuranceClaim::getClaimAmount)
                ));

        System.out.println("Average Claim Amount by Claim Type:\n");

        averageByType.forEach((type, avg) ->
                System.out.println(type + " : " + avg)
        );
    }
}

