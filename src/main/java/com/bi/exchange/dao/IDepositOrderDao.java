package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.DepositOrder;

import java.util.Map;

/**
 * 币币
 */
public interface IDepositOrderDao extends BaseDao<DepositOrder>{

    //分页查询充值历史纪录
    PageList<DepositOrder> getPageList(Page page, Map<String, Object> param);

    DepositOrder getDepositDetail(Long id);

}
