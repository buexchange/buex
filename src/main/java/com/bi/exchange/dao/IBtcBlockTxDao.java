package com.bi.exchange.dao;


import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.BtcBlockTx;

public interface IBtcBlockTxDao extends BaseDao<BtcBlockTx> {

    BtcBlockTx selectBtcBlockTx(String txHash);

}
