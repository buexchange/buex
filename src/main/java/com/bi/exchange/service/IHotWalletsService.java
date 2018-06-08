package com.bi.exchange.service;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.model.HotWallets;

import java.sql.Connection;
import java.sql.SQLException;

public interface IHotWalletsService extends BaseService<HotWallets> {

    HotWallets getUsableAddress(String assetCode) throws SQLException;

}
