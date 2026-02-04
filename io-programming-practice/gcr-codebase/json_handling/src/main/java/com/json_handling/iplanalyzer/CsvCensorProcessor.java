package com.json_handling.iplanalyzer;

import java.io.*;

public class CsvCensorProcessor {

    public static void censorCsv(String input, String output) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        String header = br.readLine();
        bw.write(header);
        bw.newLine();

        String line;
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            data[1] = CensorUtil.maskTeamName(data[1]);
            data[2] = CensorUtil.maskTeamName(data[2]);
            data[5] = CensorUtil.maskTeamName(data[5]);
            data[6] = "REDACTED";

            bw.write(String.join(",", data));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}

