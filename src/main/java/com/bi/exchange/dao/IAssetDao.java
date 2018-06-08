package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.Asset;

import java.util.List;

public interface IAssetDao extends BaseDao<Asset> {

    Asset getAssetByCode(String code);

    List<Asset> getAllAsset();

    List<Asset> getAssetChildren(Long parentId);
}
