package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.Fee;

import java.util.List;

public interface IFeeDao extends BaseDao<Fee> {

    Fee selectFeeByID(Long id);

    List<Fee> selectFeeByAssetCode(String assetCode);

}
