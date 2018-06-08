package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.CustomerInfo;

public interface ICustomerInfoDao extends BaseDao<CustomerInfo> {

    CustomerInfo getCustomerByMobile(String mobile);

    CustomerInfo getCustomerByMobile(String mobile,boolean activated);

    CustomerInfo getCustomerByEmail(String email);

    CustomerInfo getCustomerByEmail(String email,boolean activated);

    CustomerInfo getCustomerByUserName(String userName,boolean activated);

    CustomerInfo getCustomerInfoByID(Long userID);

}
