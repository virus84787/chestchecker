package com.example.chestchecker.models;

import java.io.*;

public class APIKeyInfo {
    private static String filePath = "src/main/java/com/example/chestchecker/data/API.key";

    public static String getAPIKey() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        StringBuilder lines = new StringBuilder();
        while ((line = br.readLine()) != null) {
            lines.append(line);
    }
        return lines.toString();
}

    public static void setAPIKey(String APIKey) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(APIKey);
        writer.close();
    }
}
