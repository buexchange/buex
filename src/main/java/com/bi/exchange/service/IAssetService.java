package com.bi.exchange.service;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.model.Asset;

import java.util.List;

public interface IAssetService extends BaseService<Asset> {

    Asset getAssetByCode(String code);

    List<Asset> getAssetChildren(Long parentId);

}
