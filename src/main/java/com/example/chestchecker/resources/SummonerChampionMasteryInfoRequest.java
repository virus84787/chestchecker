package com.example.chestchecker.resources;

import com.example.chestchecker.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RestController
@RequestMapping("/summonerChampionMasteryInfo")
public class SummonerChampionMasteryInfoRequest {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{server}/{summonerName}")
    public ChampionLists getChestGrantedChampions(@PathVariable("summonerName") String summonerName,
                                                  @PathVariable("server") String server) {
        ChampionLists championLists = new ChampionLists();
        try {
            SummonerInfo summonerInfo =
                    restTemplate.getForObject("https://"+server+".api.riotgames.com/lol/summoner/v4/summoners/by-name/"
                            + summonerName + "?api_key=" + APIKeyInfo.getAPIKey(), SummonerInfo.class);

            ResponseEntity<ChampionMasteryInformation[]> response =
                    restTemplate.getForEntity("https://"+server+".api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
                            + summonerInfo.getId() + "?api_key=" + APIKeyInfo.getAPIKey(), ChampionMasteryInformation[].class);

            ChampionMasteryInformation[] championsMasteryInformation = response.getBody();
            ChampionInfo championInfo = new ChampionInfo();
            championLists.setChestGrantedChampions(championInfo.convertIDsToNames(championsMasteryInformation));

            FreeChampionInfo freeChampionInfo =
                    restTemplate.getForObject("https://"+server+".api.riotgames.com/lol/platform/v3/champion-rotations?api_key="
                            + APIKeyInfo.getAPIKey(), FreeChampionInfo.class);
            championLists.setFreeChampions(championInfo.convertIDsToNames(freeChampionInfo.getFreeChampionIds()));

        }
        catch (IOException error) {
            System.out.println("error");
            error.printStackTrace();
        }
        
        return championLists;
    }
}

