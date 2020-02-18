package com.example.chestchecker.resources;

import com.example.chestchecker.models.APIChampionInfo;
import com.example.chestchecker.models.APIKeyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/settings")
public class UpdateSettingsRequest {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{settingType}/{settingValue}")
    public void updateApiKey(@PathVariable("settingType") String settingType,
                             @PathVariable("settingValue") String settingValue) {
        try {
            switch (settingType){
                case ("apiKey"):
                    APIKeyInfo.setAPIKey(settingValue);
                    break;
                case ("apiChampionVersion"):
                    APIChampionInfo.setVersionAPIChampion(settingValue);
                    break;
                default:
                    throw new NoSuchElementException("No such setting exist!");
            }

        } catch (IOException error) {
            System.out.println("error");
            error.printStackTrace();
        }
    }
}
