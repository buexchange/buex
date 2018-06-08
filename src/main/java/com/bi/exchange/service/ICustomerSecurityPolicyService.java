package com.bi.exchange.service;

import com.bi.exchange.error.ErrorCodeHandler;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.CustomerSecurityPolicy;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface ICustomerSecurityPolicyService extends BaseService<CustomerSecurityPolicy> {

    //设置用户默认安全策略
    void saveDefaultPolicy(Long userId, String type, Connection connection) throws Exception;

    String getOauth(Long userID);

    List<CustomerSecurityPolicy> getPolicyByMode(Long userID, String mode, Boolean enable);

    CustomerSecurityPolicy getPolicyBySecurityType(Long userID, String securityType);
    //设置个别策略为状态为可用
    ResponseWrapper setPolicyByMode(Long userID, String mode, String type, ErrorCodeHandler handler);
    //安全策略设置
    ResponseWrapper setPolicyByMode(Map<String,Object> param, HttpServletRequest request);

    List<CustomerSecurityPolicy> getPolicyListByUserId(Long userID,boolean isClose);

}
