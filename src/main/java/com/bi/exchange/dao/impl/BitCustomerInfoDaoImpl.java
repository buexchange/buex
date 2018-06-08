package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IBitCustomerInfoDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.CustomerInfo;
import org.springframework.stereotype.Repository;

@Repository
public class BitCustomerInfoDaoImpl extends BaseDaoForBuexImpl<CustomerInfo> implements IBitCustomerInfoDao{


    public void updateCustomerPwd(Long userID,String loginPwd){
        String sql = "UPDATE BIT_USER SET PASSWORD = ? WHERE ID = ? ";
        execUpdate(sql,loginPwd,userID);
    }

}
