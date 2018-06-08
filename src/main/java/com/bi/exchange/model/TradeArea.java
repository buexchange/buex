package com.bi.exchange.model;

import java.io.Serializable;

public class TradeArea implements Serializable {
    private Integer id ;
    private String areaName ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
