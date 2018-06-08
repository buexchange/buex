package com.bi.exchange.service;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.DepositOrder;

import java.util.Map;


public interface IDepositOrderService extends BaseService<DepositOrder>{

    //账户充值接口
//    ResponseWrapper createDepositOrder(DepositOrder depositOrder,Map<String,String> param);
    //分页查询充值历史记录
    ResponseWrapper getDepositPageList(Page page, Map<String, Object> param);
    /**
     * 获取充值记录详情
     * @param param
     * @return
     */
    ResponseWrapper getDepositDetail(Map<String,Object> param);

}
