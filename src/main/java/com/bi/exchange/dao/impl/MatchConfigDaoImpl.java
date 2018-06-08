package com.bi.exchange.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bi.exchange.dao.IMatchConfigDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.MatchConfig;

@Repository
public class MatchConfigDaoImpl extends BaseDaoImpl<MatchConfig> implements IMatchConfigDao {

    public PageList<MatchConfig> getPageList(Page page, Map<String, Object> param) {
        String sql = "select * from ex_match_config where deleted = '0'";
        return getPageListBySql(sql, page);
    }

    public MatchConfig getMatchConfigByCurrencyPair(String currencyPair) {
        String sql = "select * from ex_match_config where currency_pair=?";
        List<MatchConfig> list = getListBySql(sql, currencyPair);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}