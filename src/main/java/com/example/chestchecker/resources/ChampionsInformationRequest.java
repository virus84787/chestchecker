package com.example.chestchecker.resources;


import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;

@RestController
@RequestMapping("/championsInformation")
public class ChampionsInformationRequest {

    @RequestMapping
    public String getChampionInformation() {
        StringBuffer response = new StringBuffer();
        HashMap<Integer, String> champInfo = new HashMap<>();
        try {
            URL obj = new URL("https://ddragon.leagueoflegends.com/cdn/10.1.1/data/en_US/champion.json");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject obj_JSONObject = new JSONObject(response.toString()).getJSONObject("data");
            Iterator<String> keys = obj_JSONObject.keys();
            while (keys.hasNext())
            {
                String key = keys.next();
                JSONObject value = obj_JSONObject.getJSONObject(key);
                champInfo.put(Integer.parseInt(value.get("key").toString()), value.get("name").toString());
                System.out.println(value.get("key") + " - " + value.get("name"));
            }

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            // TODO: handle exception
        }
        return response.toString();
    }
}
