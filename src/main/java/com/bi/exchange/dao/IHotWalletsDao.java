package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.HotWallets;

import java.sql.Connection;
import java.sql.SQLException;

public interface IHotWalletsDao extends BaseDao<HotWallets>{

    HotWallets getWalletsByAsset(String assetCode);

    int updateUsableAddress(Long id) throws SQLException;

}
