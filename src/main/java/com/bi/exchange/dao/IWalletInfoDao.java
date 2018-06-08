package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.WalletInfo;

import java.util.List;
import java.util.Map;

public interface IWalletInfoDao extends BaseDao<WalletInfo> {

    WalletInfo getWalletByType(Long userid,String walletType,String assetCode);

    PageList<WalletInfo> getPageList(Page page, Map<String, Object> param);
    //查询数字资产账户是否存在
    List<WalletInfo> getListByDigitAssetAddress(String digitAssetAddress, Long userid);

}
