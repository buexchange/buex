package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.CustomerSecurityPolicy;

import java.util.List;

public interface ICustomerSecurityPolicyDao extends BaseDao<CustomerSecurityPolicy>{

    CustomerSecurityPolicy getOauth(Long userID);

    List<CustomerSecurityPolicy> getPolicyByMode(Long userID, String mode, Boolean enable);

    CustomerSecurityPolicy getPolicyBySecurityType(Long userID, String securityType);

    List<CustomerSecurityPolicy> getPolicyListByUserId(Long userId,boolean isClose);

}
