package com.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

class User {
    public String name;
    public int age;
    public String email;
}

public class JsonPojoValidation {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readValue(new File("user.json"), User.class);
            System.out.println("JSON structure matches User class");
        } catch (Exception e) {
            System.out.println("JSON structure does NOT match User class");
        }
    }
}
