package com.example.chestchecker.models;

public class ChampionMasteryInformation {
    private boolean chestGranted;
    private int championLevel;
    private int championPoints;
    private long championId;
    private long championPointsUntilNextLevel;
    private long lastPlayTime;
    private int tokensEarned;
    private long championPointsSinceLastLevel;
    private String summonerId;

    public ChampionMasteryInformation() {

    }

    public ChampionMasteryInformation(boolean chestGranted,
                                      int championLevel,
                                      int championPoints,
                                      long championId,
                                      long championPointsUntilNextLevel,
                                      long lastPlayTime,
                                      int tokensEarned,
                                      long championPointsSinceLastLevel,
                                      String summonerId) {
        this.chestGranted = chestGranted;
        this.championLevel = championLevel;
        this.championPoints = championPoints;
        this.championId = championId;
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
        this.lastPlayTime = lastPlayTime;
        this.tokensEarned = tokensEarned;
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
        this.summonerId = summonerId;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public void setChestGranted(boolean chestGranted) {
        this.chestGranted = chestGranted;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(int championPoints) {
        this.championPoints = championPoints;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public void setChampionPointsUntilNextLevel(long championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public int getTokensEarned() {
        return tokensEarned;
    }

    public void setTokensEarned(int tokensEarned) {
        this.tokensEarned = tokensEarned;
    }

    public long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public void setChampionPointsSinceLastLevel(long championPointsSinceLastLevel) {
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }
}
