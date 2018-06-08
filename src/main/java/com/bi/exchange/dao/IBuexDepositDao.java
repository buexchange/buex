package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.DepositOrder;

public interface IBuexDepositDao extends BaseDao<DepositOrder> {

    DepositOrder getDepositDetail(Long id);

}
