package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCSVReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "large_file.csv";
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header row
            br.readLine();

            String line;
            List<String> chunk = new ArrayList<>(CHUNK_SIZE);

            while ((line = br.readLine()) != null) {

                chunk.add(line);
                totalRecords++;

                // Process 100 lines at a time
                if (chunk.size() == CHUNK_SIZE) {
                    processChunk(chunk);
                    chunk.clear();
                }
            }

            // Process remaining lines (less than 100)
            if (!chunk.isEmpty()) {
                processChunk(chunk);
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            System.out.println("Error reading large CSV file");
        }
    }

    private static void processChunk(List<String> chunk) {
        // Simulate processing
        System.out.println("Processed records: " + chunk.size());
    }
}
