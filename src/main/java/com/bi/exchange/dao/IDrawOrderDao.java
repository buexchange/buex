package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.DrawOrder;

import java.util.Map;

public interface IDrawOrderDao extends BaseDao<DrawOrder>{

    DrawOrder getByUserIdAndUpdateTime(Long userid, String updateTime);

    PageList<DrawOrder> getPageList(Page page, Map<String, Object> map);

}
