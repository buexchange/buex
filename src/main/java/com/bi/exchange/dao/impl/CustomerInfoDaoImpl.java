package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ICustomerInfoDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.model.CustomerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerInfoDaoImpl extends BaseDaoImpl<CustomerInfo> implements ICustomerInfoDao {

    @Override
    public CustomerInfo getCustomerByMobile(String mobile) {
        String sql = "select * from ex_customer_info where mobile = ? and  deleted = '0' ";
        List<CustomerInfo> customerInfoList = getListBySql(sql,mobile);
        if(customerInfoList.size()>0){
            return customerInfoList.get(0);
        }
        return null;
    }

    @Override
    public CustomerInfo getCustomerByMobile(String mobile, boolean activated) {
        String sql = "select * from ex_customer_info where mobile = ? and  deleted = '0' ";
        if(activated)
            sql += " and activated = '1' ";
        else
            sql += " and activated = '0' ";

        List<CustomerInfo> customerList = getListBySql(sql, mobile);

        if (customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    @Override
    public CustomerInfo getCustomerByEmail(String email) {
        String sql = "select * from ex_customer_info where email = ? and deleted = '0'";
        List<CustomerInfo> customerInfoList = getListBySql(sql,email);
        if(customerInfoList.size()>0){
            return customerInfoList.get(0);
        }
        return null;
    }

    @Override
    public CustomerInfo getCustomerByEmail(String email, boolean activated) {
        String sql = "select * from ex_customer_info where email=? and deleted = '0' ";
        if(activated)
            sql += " and activated = '1' ";
        else
            sql += " and activated = '0' ";

        List<CustomerInfo> customerList = getListBySql(sql, email);

        if (customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    @Override
    public CustomerInfo getCustomerByUserName(String userName, boolean activated) {
        String sql = "select * from ex_customer_info where (mobile=? or email = ?) and deleted = '0' ";
        if(activated)
            sql+=" and activated='1'";
        else
            sql+=" and activated='0'";

        List<CustomerInfo> customerList = getListBySql(sql, userName, userName);

        if (customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    @Override
    public CustomerInfo getCustomerInfoByID(Long userID) {
        String sql = "select * from ex_customer_info where id = ? and deleted = '0'";
        List<CustomerInfo> customerInfos = getListBySql(sql,userID);
        if(customerInfos.size()>0){
            return customerInfos.get(0);
        }
        return null;
    }


}
