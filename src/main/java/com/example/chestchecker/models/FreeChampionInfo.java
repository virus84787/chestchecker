package com.example.chestchecker.models;

import java.util.List;

public class FreeChampionInfo {
    private List<Integer> freeChampionIdsForNewPlayers;
    private List<Integer> freeChampionIds;
    private int maxNewPlayerLevel;

    public FreeChampionInfo() {
    }

    public FreeChampionInfo(List<Integer> freeChampionIdsForNewPlayers, List<Integer> freeChampionIds, int maxNewPlayerLevel) {
        this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
        this.freeChampionIds = freeChampionIds;
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }

    public List<Integer> getFreeChampionIdsForNewPlayers() {
        return freeChampionIdsForNewPlayers;
    }

    public void setFreeChampionIdsForNewPlayers(List<Integer> freeChampionIdsForNewPlayers) {
        this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
    }

    public List<Integer> getFreeChampionIds() {
        return freeChampionIds;
    }

    public void setFreeChampionIds(List<Integer> freeChampionIds) {
        this.freeChampionIds = freeChampionIds;
    }

    public int getMaxNewPlayerLevel() {
        return maxNewPlayerLevel;
    }

    public void setMaxNewPlayerLevel(int maxNewPlayerLevel) {
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }
}
