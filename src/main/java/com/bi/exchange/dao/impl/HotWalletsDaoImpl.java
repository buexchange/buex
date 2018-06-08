package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IHotWalletsDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.HotWallets;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HotWalletsDaoImpl extends BaseDaoForBuexImpl<HotWallets> implements IHotWalletsDao{

    @Override
    public HotWallets getWalletsByAsset(String assetCode) {
        String sql = "select * from bit_hotwallets where type = ? and  isuse != 1";
        List<HotWallets> listBySql = getListBySql(sql, assetCode);
        if (listBySql.size() > 0) {
            return listBySql.get(0);
        }
        return null;
    }

    @Override
    public int updateUsableAddress(Long id) throws SQLException {
        String sql = "update bit_hotwallets set isuse = 1 where id = ? and isuse!=1";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = getJdbcTemplate().getDataSource().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}
