package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IBankInfoDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.BankInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BankInfoDaoImpl extends BaseDaoImpl<BankInfo> implements IBankInfoDao {


    @Override
    public void updateBankInfoNoDefault(Long userid) {
        String sql = "update ex_bank_info set is_default = '0' where deleted = '0' and user_id = ?";
        execUpdate(sql, userid);
    }

    @Override
    public BankInfo getBankByAccount(String bankAccount) {
        String sql = "select * from ex_bank_info where deleted = '0' and BANK_ACCOUNT = ?";
        List<BankInfo> bankInfoList = getListBySql(sql, bankAccount);
        if(bankInfoList.size()>0){
            return bankInfoList.get(0);
        }
        return null;
    }

    @Override
    public void updateBankInfoIsDefault(String id) {
        String sql = "update ex_bank_info set is_default = '1' where deleted = '0' and id = ?";
        execUpdate(sql, id);
    }

    @Override
    public BankInfo getBankInfoById(Long id,Long userid) {
        String sql = "select * from ex_bank_info where deleted = '0' and id = ? and user_id = ?";
        List<BankInfo> bankInfoList = getListBySql(sql, id,userid);
        if(bankInfoList.size()>0){
            return bankInfoList.get(0);
        }
        return null;
    }

    public BankInfo getBankInfoByAccount(String bankAccount) {
        String sql = "select * from ex_bank_info where deleted = '0' and bank_account = ? ";
        List<BankInfo> list = getListBySql(sql, bankAccount);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageList<BankInfo> getBankInfoByPage(Page page, Map<String, Object> params) {
        String userId = StringUtil.getString(params.get("userid"));
        String startTime = StringUtil.getString(params.get("starttime"));
        String endTime = StringUtil.getString(params.get("endtime"));
        String sql = "select * from ex_bank_info where deleted = '0' and user_id = ?";
        if(StringUtil.isNotBlank(startTime) && StringUtil.isNotBlank(endTime)){
            sql+=" and create_time >= to_date('"+ startTime +"','yyyy-MM-dd HH24:mi:ss')" +
                 " and create_time <= to_date('"+ endTime +"','yyyy-MM-dd HH24:mi:ss')  ";
        }
        sql+=" order by create_time desc";
        return getPageListBySqlWithNext(sql,page,userId);
    }

}
