package com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO;


/**
 * Champion class for JSON mapping
 */
public class Champion {
    private Integer id;
    private String key;
    private String name;
    private String title;

    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }
}
