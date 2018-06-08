package com.bi.exchange.dao;

import com.bi.exchange.model.KLine;

import java.util.List;

public interface IKLineDao {

    List<KLine> selectKlineForPage(String tableName);

}
