package com.json_handling.iplanalyzer;

public class CensorUtil {

    public static String maskTeamName(String team) {
        if (team == null || !team.contains(" ")) {
            return team;
        }
        return team.substring(0, team.indexOf(" ")) + " ***";
    }
}
