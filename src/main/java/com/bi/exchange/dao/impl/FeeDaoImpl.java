package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IFeeDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.model.Fee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeeDaoImpl extends BaseDaoImpl<Fee> implements IFeeDao {

    @Override
    public Fee selectFeeByID(Long id) {
        String sql="SELECT * from EX_FEE WHERE ID=?";
        List<Fee> feeList = getListBySql(sql,id);
        if(feeList.size()>0){
            return feeList.get(0);
        }
        return null;
    }

    @Override
    public List<Fee> selectFeeByAssetCode(String assetCode) {
        String sql = "select * from ex_fee where assetcode = ?";
        List<Fee> feeList = getListBySql(sql,assetCode);
        return feeList;
    }
}
