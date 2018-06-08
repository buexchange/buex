package com.bi.exchange.dao;


import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.BitUserMoney;

import java.math.BigDecimal;
import java.sql.Connection;

/**
 * 场外交易用户资产
 */
public interface IUserMoneyDao extends BaseDao<BitUserMoney> {

    Connection getConnection() throws Exception;

    BitUserMoney getAssetByAssetCode(Long userid, String assetCode);

    int updateAsset(Long id, BigDecimal amount, String flag, Connection connection) throws Exception;

}
