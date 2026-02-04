package com.json_handling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class EmailSchemaValidation {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.readTree(new File("user.json"));
        JsonNode schemaNode = JsonLoader.fromFile(
                new File("user-schema.json")
        );

        JsonSchemaFactory factory =
                JsonSchemaFactory.byDefault();

        JsonSchema schema = factory.getJsonSchema(schemaNode);

        ProcessingReport report = schema.validate(jsonData);

        if (report.isSuccess()) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email is invalid");
            report.forEach(msg ->
                System.out.println(msg.getMessage())
            );
        }
    }
}

