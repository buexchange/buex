package com.bi.exchange.service;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.CustomerAsset;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public interface ICustomerAssetService extends BaseService<CustomerAsset>{

    Connection getConnection() throws Exception;

    void setAsset(Long userid, Connection connection) throws Exception;

    ResponseWrapper cnyAccount(Map<String, Object> param);
    //获取某用户资产信息
    CustomerAsset getAssetByAssetCode(Long userid, String assetCode);
    //提现冻结用户金额
    int updateAssetByDraw(Long id, BigDecimal drawAmount, Connection connection) throws SQLException;

    CustomerAsset checkAmount(Long id, String type, BigDecimal freezeAmt);

    int updateAmount(Long id, BigDecimal freezeAmt, Connection connection) throws Exception;

    /**
     * 根据用户UUID 获取用户资产计算 总资产 净资产 返回map
     *
     * @param userid
     * @return
     */
    Map<String,Object> getCustomerAssetByUserId(Long userid);

    ResponseWrapper queryCustomerAssert(Map<String, Object> param);

    /**
     * 平台资金划转
     * @param param
     * @return
     */
    ResponseWrapper assetTransfer(Map<String,Object> param);

}
