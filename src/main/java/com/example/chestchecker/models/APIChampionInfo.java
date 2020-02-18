package com.example.chestchecker.models;

import java.io.*;

public class APIChampionInfo {
    private static String filePath = "src/main/java/com/example/chestchecker/data/API.champions";

    public static String getAPIChampion() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        StringBuilder lines = new StringBuilder();
        while ((line = br.readLine()) != null) {
            lines.append(line);
        }
        return lines.toString();
    }

    public static void setAPIChampion(String APIChampion) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(APIChampion);
        writer.close();
    }

    public static void setVersionAPIChampion(String versionAPIChampion) throws IOException {
        String APIChampion = "https://ddragon.leagueoflegends.com/cdn/"
                + versionAPIChampion + "/data/en_US/champion.json";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(APIChampion);
        writer.close();
    }
}
