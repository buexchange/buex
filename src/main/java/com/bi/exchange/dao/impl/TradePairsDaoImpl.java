package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ITradePairsDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.model.TradePairs;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TradePairsDaoImpl extends BaseDaoImpl<TradePairs> implements ITradePairsDao {
    @Override
    public List<String> getAllTradeArea() {
        List<String> areas = new ArrayList<>();
        try{
            String sql = "SELECT AREANAME FROM EX_TRADEAREA";
            List<String> list = getJdbcTemplate().queryForList(sql, String.class);
            if(list!=null && list.size()>0){
                for(String area : list){
                    areas.add(area.toLowerCase());
                }
            }
            return areas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getAllTradePairs() {
        try{
            String sql = "SELECT CURRPAIRS FROM EX_TRADEPAIRS";
            return getJdbcTemplate().queryForList(sql,String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
