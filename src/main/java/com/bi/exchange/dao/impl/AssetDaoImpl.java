package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IAssetDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.model.Asset;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetDaoImpl extends BaseDaoImpl<Asset> implements IAssetDao{

    @Override
    public Asset getAssetByCode(String code) {
        String sql = "select * from ex_asset where deleted='0' and asset_code = ? ";
        List<Asset> list = getListBySql(sql,code);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Asset> getAllAsset() {
        String sql = "select * from ex_asset where deleted='0'";
        return getListBySql(sql);
    }

    @Override
    public List<Asset> getAssetChildren(Long parentId) {
        String sql = "select * from ex_asset where deleted='0' and parent_id = ? ";
        return getListBySql(sql,parentId);
    }
}
