package com.bi.exchange.service;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.Order;

import java.util.Map;

public interface IOrderService extends BaseService<Order> {

    ResponseWrapper getOrderById(Map<String, Object> param);

    ResponseWrapper findOrderById(Map<String, Object> param);

    ResponseWrapper getFreezeAmtById(Map<String, Object> param);

    ResponseWrapper orderByAPI(Map<String, Object> param);

    ResponseWrapper getTickerByAPI(Map<String, Object> param);

    ResponseWrapper createOrder(Map<String,Object> param);

    ResponseWrapper revokeOrder(Map<String,Object> param);

    ResponseWrapper batchRevoke(Map<String,Object> param);

    ResponseWrapper changeOrder(Map<String, Object> param);

    ResponseWrapper getRecordList(Page page,Map<String, Object> param);

    ResponseWrapper getPageList(Page page,Map<String,Object> param);

    ResponseWrapper orderByTest(Map<String, Object> param);

}
