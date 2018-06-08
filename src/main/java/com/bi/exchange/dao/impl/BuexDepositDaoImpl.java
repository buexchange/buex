package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IBuexDepositDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.DepositOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuexDepositDaoImpl extends BaseDaoForBuexImpl<DepositOrder> implements IBuexDepositDao {

    @Override
    public DepositOrder getDepositDetail(Long id) {
        String sql = "select * from bit_depositorder where id = ?";
        List<DepositOrder> list = getListBySql(sql,id);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

}
