package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IBtcBlockTxDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.BtcBlockTx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BtcBlockTxDaoImpl extends BaseDaoForBuexImpl<BtcBlockTx> implements IBtcBlockTxDao {

    @Override
    public BtcBlockTx selectBtcBlockTx(String txHash) {
        String sql = "select * from BIT_BTCBLOCKTX where txhash = ?";
        List<BtcBlockTx> list = getListBySql(sql,txHash);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
