package com.example.chestchecker.models;

import java.util.ArrayList;
import java.util.List;

public class ChampionLists {
    private List<String> chestGrantedChampions = new ArrayList<>();
    private List<String> freeChampions = new ArrayList<>();

    public List<String> getChestGrantedChampions() {
        return chestGrantedChampions;
    }

    public void setChestGrantedChampions(List<String> chestGrantedChampions) {
        this.chestGrantedChampions = chestGrantedChampions;
        java.util.Collections.sort(chestGrantedChampions);
    }

    public List<String> getFreeChampions() {
        return freeChampions;
    }

    public void setFreeChampions(List<String> freeChampions) {
        this.freeChampions = freeChampions;
    }
}
