package com.bi.exchange.dao;


import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.TradePairs;

import java.util.List;

public interface ITradePairsDao extends BaseDao<TradePairs> {

    /**
     * 获取所有的交易区 如 usdt交易区 btc交易区  eth交易区
     * @return
     */
    List<String> getAllTradeArea();

    /**
     * 获取所有的交易对
     * @return
     */
    List<String> getAllTradePairs();

}
