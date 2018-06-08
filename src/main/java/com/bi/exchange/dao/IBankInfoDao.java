package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.BankInfo;

import java.util.Map;

public interface IBankInfoDao extends BaseDao<BankInfo> {

    //根据userid设置银行卡为不默认
    void updateBankInfoNoDefault(Long userid);

    BankInfo getBankByAccount(String bankAccount);

    void updateBankInfoIsDefault(String id);

    BankInfo getBankInfoById(Long id,Long userid);

    BankInfo getBankInfoByAccount(String bankAccount);

    PageList<BankInfo> getBankInfoByPage(Page page,Map<String,Object> params);

}
