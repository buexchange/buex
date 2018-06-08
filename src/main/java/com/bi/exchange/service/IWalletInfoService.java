package com.bi.exchange.service;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.WalletInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public interface IWalletInfoService extends BaseService<WalletInfo> {

    void saveWithConnection(WalletInfo walletInfo, Connection connection) throws SQLException;
    //获取充值数字资产地址
    ResponseWrapper getWalletByType(Map<String,Object> param, HttpServletRequest request);
    //分页获取数字资产地址
    ResponseWrapper getWalletPageList(Page page, Map<String, Object> param);
    //创建数字资产账户
    ResponseWrapper createWalletInfo(WalletInfo walletInfo, Map<String, Object> param,HttpServletRequest request);
    //删除数字资产账户
    ResponseWrapper deleteWalletInfo(Map<String, Object> param);

}
