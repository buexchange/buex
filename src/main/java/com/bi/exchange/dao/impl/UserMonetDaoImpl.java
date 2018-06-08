package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IUserMoneyDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.BitUserMoney;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UserMonetDaoImpl extends BaseDaoForBuexImpl<BitUserMoney> implements IUserMoneyDao {


    @Override
    public Connection getConnection() throws Exception {
        return getJdbcTemplate().getDataSource().getConnection();
    }

    @Override
    public BitUserMoney getAssetByAssetCode(Long userid, String assetCode) {
        String sql = "select * from bit_usermoney where userid=? and assetcode=?";
        List<BitUserMoney> list = getListBySql(sql, userid, assetCode);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateAsset(Long id, BigDecimal amount, String flag, Connection connection) throws Exception {
        String sql = null;
        if("0".equals(flag))
            sql = "update bit_usermoney set assetamt = assetamt-?, usableamt = usableamt-?,updatetime = sysdate where id =? and usableamt >= ? ";
        if("1".equals(flag))
            sql = "update bit_usermoney set assetamt = assetamt+?, usableamt = usableamt+?,updatetime = sysdate where id =? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setBigDecimal(1,amount);
            ps.setBigDecimal(2,amount);
            ps.setLong(3,id);
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
