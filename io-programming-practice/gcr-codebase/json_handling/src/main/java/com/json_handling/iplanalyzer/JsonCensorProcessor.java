package com.json_handling.iplanalyzer;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class JsonCensorProcessor {

    public static void censorJson(String input, String output) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode matches = (ArrayNode) mapper.readTree(new File(input));
        ArrayNode censoredMatches = mapper.createArrayNode();

        for (JsonNode match : matches) {

            ObjectNode censored = mapper.createObjectNode();

            censored.put("match_id", match.get("match_id").asInt());

            String team1 = match.get("team1").asText();
            String team2 = match.get("team2").asText();

            censored.put("team1", CensorUtil.maskTeamName(team1));
            censored.put("team2", CensorUtil.maskTeamName(team2));

            ObjectNode scoreNode = mapper.createObjectNode();
            Iterator<Map.Entry<String, JsonNode>> scores =
                    match.get("score").fields();

            while (scores.hasNext()) {
                Map.Entry<String, JsonNode> entry = scores.next();
                scoreNode.put(
                    CensorUtil.maskTeamName(entry.getKey()),
                    entry.getValue().asInt()
                );
            }

            censored.set("score", scoreNode);
            censored.put("winner",
                CensorUtil.maskTeamName(match.get("winner").asText()));
            censored.put("player_of_match", "REDACTED");

            censoredMatches.add(censored);
        }

        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(output), censoredMatches);
    }
}

