package com.json_handling;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvToJson {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        BufferedReader br = new BufferedReader(
                new FileReader("students.csv"));

        String headerLine = br.readLine();
        String[] headers = headerLine.split(",");

        String line;
        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");
            ObjectNode jsonObject = mapper.createObjectNode();

            for (int i = 0; i < headers.length; i++) {
                jsonObject.put(headers[i], values[i]);
            }

            jsonArray.add(jsonObject);
        }

        br.close();

        System.out.println(
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValueAsString(jsonArray)
        );
    }
}

