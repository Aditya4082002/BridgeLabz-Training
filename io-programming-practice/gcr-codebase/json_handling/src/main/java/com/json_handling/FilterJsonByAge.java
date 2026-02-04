package com.json_handling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterJsonByAge {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File("users.json"));

        System.out.println("Users with age > 25:");
        System.out.println("--------------------");

        for (JsonNode user : rootNode) {

            int age = user.get("age").asInt();

            if (age > 25) {
                String name = user.get("name").asText();
                String email = user.get("email").asText();

                System.out.println("Name  : " + name);
                System.out.println("Age   : " + age);
                System.out.println("Email : " + email);
                System.out.println("--------------------");
            }
        }
    }
}
