package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ICustomerAssetDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.util.Misc;
import com.bi.exchange.model.CustomerAsset;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerAssetDaoImpl extends BaseDaoImpl<CustomerAsset> implements ICustomerAssetDao {

    @Override
    public Connection getConnection() throws SQLException {
        return getJdbcTemplate().getDataSource().getConnection();
    }

    @Override
    public List<CustomerAsset> getAsset(Long userid) {
        String sql = "select * from ex_customer_asset where deleted = '0' and user_id = ?";
        List<CustomerAsset> customerAssetList = getListBySql(sql, userid);
        return customerAssetList;

    }

    @Override
    public CustomerAsset getAssetByAssetCode(Long userid, String assetCode) {
        String sql = "select * from ex_customer_asset where deleted='0' and user_id=? and asset_code=?";
        List<CustomerAsset> list = getListBySql(sql, userid, assetCode);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateAssetByDraw(Long id, BigDecimal drawAmount, Connection connection) throws SQLException {
        String sql = "update ex_customer_asset set freeze_amt = freeze_amt+?, usable_amt = usable_amt-?,update_time = sysdate where id =? and usable_amt >= ? ";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            int i = 0;
            ps.setBigDecimal(++i, drawAmount);
            ps.setBigDecimal(++i, drawAmount);
            ps.setLong(++i, id);
            ps.setBigDecimal(++i, drawAmount);
            return ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public CustomerAsset checkAmount(Long userId, String type, BigDecimal freezeAmt) {
        String sql = "select * from ex_customer_asset" +
                " where user_id = ? and usable_amt >= ? and asset_code = ? and deleted = '0'";
        List<CustomerAsset> listBySql = getListBySql(sql, userId, freezeAmt, type);
        if (listBySql.size() > 0) {
            return listBySql.get(0);
        }
        return null;
    }

    @Override
    public int updateAmount(Long id, BigDecimal freezeAmt, Connection connection) throws SQLException {
        String sql = "update ex_customer_asset set freeze_amt = freeze_amt+?, usable_amt = usable_amt-?,update_time = sysdate where id =? and usable_amt >= ? ";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            int i = 0;
            ps.setBigDecimal(++i, freezeAmt);
            ps.setBigDecimal(++i, freezeAmt);
            ps.setLong(++i, id);
            ps.setBigDecimal(++i, freezeAmt);
            return ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public int updateAssetAmt(Long id, BigDecimal amount,String flag, Connection connection) throws Exception {
        String sql = null;
        //减少
        if("0".equals(flag))
            sql = "update ex_customer_asset set asset_amt = asset_amt-?, usable_amt = usable_amt-?,update_time = sysdate where id =? and usable_amt >= ? ";
        //新增
        if("1".equals(flag))
            sql = "update ex_customer_asset set asset_amt = asset_amt+?, usable_amt = usable_amt+?,update_time = sysdate where id =? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setBigDecimal(1,amount);
            ps.setBigDecimal(2,amount);
            ps.setLong(3, id);
            if("0".equals(flag))
                ps.setBigDecimal(4,amount);
            return ps.executeUpdate();
        }finally {
            if(ps != null){
                ps.close();
            }
        }
    }



}
