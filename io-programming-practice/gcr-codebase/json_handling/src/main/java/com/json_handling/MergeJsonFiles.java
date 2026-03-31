package com.json_handling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class MergeJsonFiles {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode json1 =
                (ObjectNode) mapper.readTree(new File("file1.json"));
        ObjectNode json2 =
                (ObjectNode) mapper.readTree(new File("file2.json"));

        ObjectNode merged = merge(json1, json2);

        System.out.println(merged.toPrettyString());
    }

    private static ObjectNode merge(
            ObjectNode mainNode,
            ObjectNode updateNode) {

        Iterator<Map.Entry<String, JsonNode>> fields =
                updateNode.fields();

        while (fields.hasNext()) {

            Map.Entry<String, JsonNode> entry = fields.next();
            String fieldName = entry.getKey();
            JsonNode value = entry.getValue();

            if (mainNode.has(fieldName)
                    && mainNode.get(fieldName).isObject()
                    && value.isObject()) {

                merge(
                    (ObjectNode) mainNode.get(fieldName),
                    (ObjectNode) value
                );

            } else {
                mainNode.set(fieldName, value);
            }
        }

        return mainNode;
    }
}