package com.bi.exchange.service;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.model.UserAssetRecord;
import org.springframework.security.access.method.P;

import java.util.Map;

public interface IUserAssetRecordService extends BaseService<UserAssetRecord> {

    //根据userID查询账户全部记录
    PageList<UserAssetRecord> getPageListByType(Page page, Map<String, Object> param);

}
