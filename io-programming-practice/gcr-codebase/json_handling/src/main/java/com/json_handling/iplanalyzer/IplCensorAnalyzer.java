package com.json_handling.iplanalyzer;

public class IplCensorAnalyzer {

    public static void main(String[] args) {

        try {
            JsonCensorProcessor.censorJson(
                "ipl_matches.json",
                "ipl_matches_censored.json"
            );

            CsvCensorProcessor.censorCsv(
                "ipl_matches.csv",
                "ipl_matches_censored.csv"
            );

            System.out.println("Censorship completed successfully.");

        } catch (Exception e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}

