package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.CustomerIdentify;

public interface ICustomerIdentifyDao extends BaseDao<CustomerIdentify>{

    CustomerIdentify getIdentifyByUserID(Long userID);

    CustomerIdentify findByCode(String code);

}
