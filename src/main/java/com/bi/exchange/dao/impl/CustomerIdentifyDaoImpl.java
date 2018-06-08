package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ICustomerIdentifyDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.CustomerIdentify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerIdentifyDaoImpl extends BaseDaoForBuexImpl<CustomerIdentify> implements ICustomerIdentifyDao {

    @Override
    public CustomerIdentify getIdentifyByUserID(Long userID) {
        String sql = "select * from bit_useridentify where userid = ? ";
        List<CustomerIdentify> customerIdentifyList = getListBySql(sql, userID);
        if (customerIdentifyList.size() > 0) {
            return customerIdentifyList.get(0);
        }
        return null;
    }

    @Override
    public CustomerIdentify findByCode(String code) {
        String sql = "select * from bit_useridentify where credentialscode = ? ";
        List<CustomerIdentify> customerIdentifyList = getListBySql(sql, code);
        if (customerIdentifyList.size() > 0) {
            return customerIdentifyList.get(0);
        }
        return null;
    }
}
