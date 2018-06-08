package com.bi.exchange.service;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.CustomerIdentify;

import java.util.Map;

public interface ICustomerIdentifyService extends BaseService<CustomerIdentify>{

    CustomerIdentify getIdentifyByUserID(Long userID);

    ResponseWrapper createByCode(Map<String, Object> paramToMap);
    //根据身份证号码查询客户认证情况
    CustomerIdentify getIdentifyByCode(String idCode);

}
