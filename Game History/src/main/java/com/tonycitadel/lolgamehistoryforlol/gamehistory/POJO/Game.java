package com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO;

/**
 * Game class for JSON mapping
 */
public class Game {
    private Integer gameId;
    private Boolean invalid;
    private String gameMode;
    private String gameType;
    private String subType;
    private Integer mapId;
    private Integer teamId;
    private Integer championId;
    private Integer spell1;
    private Integer spell2;
    private Integer level;
    private Integer ipEarned;
    private Long createDate;
    private Stats stats;
    private String championName;
    private String championKey;

    public String getChampionKey() {
        return championKey;
    }

    public void setChampionKey(String championKey) {
        this.championKey = championKey;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public String getSubType() {
        return subType;
    }

    public Integer getMapId() {
        return mapId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getChampionId() {
        return championId;
    }

    public Integer getSpell1() {
        return spell1;
    }

    public Integer getSpell2() {
        return spell2;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getIpEarned() {
        return ipEarned;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public Stats getStats() {
        return stats;
    }
}
