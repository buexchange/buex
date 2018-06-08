package com.bi.exchange.dao;


import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.CustomerInfo;

public interface IBitCustomerInfoDao extends BaseDao<CustomerInfo> {

    void updateCustomerPwd(Long userID,String loginPwd);

}
