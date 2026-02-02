package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        // Map<ID, "Name,Age">
        Map<String, String> studentInfo = new HashMap<>();

        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter writer = new FileWriter(outputFile)
        ) {

            // Skip header of first file
            br1.readLine();
            String line;

            // Read students1.csv
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentInfo.put(data[0], data[1] + "," + data[2]);
            }

            // Write header to merged file
            writer.write("ID,Name,Age,Marks,Grade\n");

            // Skip header of second file
            br2.readLine();

            // Read students2.csv and merge
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (studentInfo.containsKey(id)) {
                    writer.write(
                        id + "," +
                        studentInfo.get(id) + "," +
                        data[1] + "," +
                        data[2] + "\n"
                    );
                }
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            System.out.println("Error processing CSV files");
        }
    }
}
