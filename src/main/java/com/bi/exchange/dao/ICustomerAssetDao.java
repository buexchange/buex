package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.CustomerAsset;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerAssetDao extends BaseDao<CustomerAsset> {

    Connection getConnection() throws Exception;

    List<CustomerAsset> getAsset(Long userid);
    //获取用户今天之前的最新资产
    //BigDecimal getLatestAsset(Long userid);
    //根据资产编号和用户ID查询资产信息
    CustomerAsset getAssetByAssetCode(Long userid, String assetCode);

    int updateAssetByDraw(Long id, BigDecimal drawAmount, Connection connection) throws SQLException;

    CustomerAsset checkAmount(Long id, String type, BigDecimal freezeAmt);

    int updateAmount(Long id, BigDecimal freezeAmt, Connection connection) throws Exception;
    //更新用户资产 flag 0增加资产 1 减少资产
    int updateAssetAmt(Long id,BigDecimal amount,String flag,Connection connection) throws Exception;
}
