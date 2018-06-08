package com.bi.exchange.model;

import java.io.Serializable;

public class TradePairs implements Serializable {
    private Integer areaId ;
    private String areaName ;
    private String pairs ;
    private String currPairs ;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPairs() {
        return pairs;
    }

    public void setPairs(String pairs) {
        this.pairs = pairs;
    }

    public String getCurrPairs() {
        return currPairs;
    }

    public void setCurrPairs(String currPairs) {
        this.currPairs = currPairs;
    }
}
