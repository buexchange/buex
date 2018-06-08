package com.bi.exchange.dao;

import java.util.Map;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.MatchConfig;

public interface IMatchConfigDao extends BaseDao<MatchConfig> {
    PageList<MatchConfig> getPageList(Page page, Map<String, Object> param);

    MatchConfig getMatchConfigByCurrencyPair(String currencyPair);
}
