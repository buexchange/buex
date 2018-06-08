package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.UserAssetRecord;

import java.util.Map;

public interface IUserAssetRecordDao extends BaseDao<UserAssetRecord> {

    PageList<UserAssetRecord> getPageList(Page page, Map<String, Object> param, String type);

}
