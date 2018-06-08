package com.bi.exchange.service;

import java.util.Map;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.model.MatchConfig;

public interface IMatchConfigService extends BaseService<MatchConfig> {
	PageList<MatchConfig> getPageList(Page page, Map<String, Object> param);

    MatchConfig getMatchConfigByCurrencyPair(String currencyPair);
}
