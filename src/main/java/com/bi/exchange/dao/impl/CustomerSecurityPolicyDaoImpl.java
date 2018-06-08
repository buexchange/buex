package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ICustomerSecurityPolicyDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.CustomerSecurityPolicy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerSecurityPolicyDaoImpl extends BaseDaoImpl<CustomerSecurityPolicy> implements ICustomerSecurityPolicyDao {

    @Override
    public CustomerSecurityPolicy getOauth(Long userID) {
        String sql = "select security_id from ex_customer_security_policy where user_id = ? and validation_mode = 'login' and is_enabled = '1' and deleted = '0'";
        List<CustomerSecurityPolicy> listPolicies = getListBySql(sql, userID);
        if (listPolicies.size() > 0) {
            return listPolicies.get(0);
        }
        return null;
    }

    @Override
    public List<CustomerSecurityPolicy> getPolicyByMode(Long userID, String mode, Boolean enable) {
        String sql = "select * from ex_customer_security_policy where user_id = ? and deleted = '0'";
        List<CustomerSecurityPolicy> listPolicies;
        if (enable != null) {
            if (enable) {
                sql += " and is_enabled = '1' ";
            } else {
                sql += " and is_enabled = '0' ";
            }
        }

        if (StringUtil.isNotBlank(mode)) {
            sql += " and validation_mode = ? ";
            listPolicies = getListBySql(sql, userID, mode);
        } else {
            listPolicies = getListBySql(sql, userID);
        }

        if (listPolicies.size() > 0) {
            return listPolicies;
        }
        return null;
    }

    @Override
    public CustomerSecurityPolicy getPolicyBySecurityType(Long userID, String securityType) {
        String sql = "select id,security_id,validation_mode,is_enabled from ex_customer_security_policy where deleted = '0' and user_id = ? and is_enabled = '1' and validation_mode = ?";
        List<CustomerSecurityPolicy> list = getListBySql(sql, userID, securityType);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<CustomerSecurityPolicy> getPolicyListByUserId(Long userID,boolean isClose){
        String sql ="select * from ex_customer_security_policy where deleted = '0' and user_id=? and validation_mode<>'trade' ";
        if(isClose){
            sql+=" and is_enabled = '1' ";
        }else{
            sql+=" and is_recent = '1' ";
        }
        List<CustomerSecurityPolicy> list = getListBySql(sql, userID);
        if(list.size()>0){
            return list;
        }
        return null;
    }
}
