package com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Model Class for JSON mapping
 */
public class Model {
    private Integer summonerId;
    private List<Game> games = new ArrayList<Game>();

    public Integer getSummonerId() {
        return summonerId;
    }

    public List<Game> getGames() {
        return games;
    }
}
