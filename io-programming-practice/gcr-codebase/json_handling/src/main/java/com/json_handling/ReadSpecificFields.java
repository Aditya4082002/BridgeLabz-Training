package com.json_handling;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadSpecificFields {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(new File("user.json"));

        String name = rootNode.get("name").asText();
        String email = rootNode.get("email").asText();

        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}

