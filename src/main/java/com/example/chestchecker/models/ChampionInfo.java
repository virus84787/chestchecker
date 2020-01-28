package com.example.chestchecker.models;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ChampionInfo {
    private static HashMap<Integer, String> champInfo = new HashMap<>();

    public ChampionInfo() {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(APIChampionInfo.getAPIChampion());
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
            }

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public HashMap<Integer, String> getChampInfo() {
        return champInfo;
    }

    HashMap<Integer, String> mapChampionInfo = this.getChampInfo();

    public List<String> convertIDsToNames(ChampionMasteryInformation[] championsMasteryInformation) {
        List<String> chestGrantedChampions = new ArrayList<>();
        for (ChampionMasteryInformation champInfo : championsMasteryInformation) {
            if (champInfo.isChestGranted()) {
                chestGrantedChampions.add(mapChampionInfo.get((int) champInfo.getChampionId()));
            }
        }
        return chestGrantedChampions;
    }

    public List<String> convertIDsToNames(List<Integer> freeChampionIds) {
        List<String> chestGrantedChampions = new ArrayList<>();
        for (Integer champId : freeChampionIds) {
                chestGrantedChampions.add(mapChampionInfo.get(champId));
        }
        return chestGrantedChampions;
    }
}
