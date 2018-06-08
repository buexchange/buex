package com.bi.exchange.service;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.DrawOrder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IDrawOrderService extends BaseService<DrawOrder>{

    DrawOrder getByUserIdAndUpdateTime(Long userId, String updateTime);
    //验证资金密码等并创建提现订单
    ResponseWrapper createDrawOrder(Map<String, Object> map, HttpServletRequest request);
    //分页查询提现订单列表
    ResponseWrapper getPageList(Page page, Map<String, Object> param);

    ResponseWrapper getFeeList(Map<String,Object> param);

}
