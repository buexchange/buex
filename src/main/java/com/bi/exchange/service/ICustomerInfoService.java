package com.bi.exchange.service;

import com.bi.exchange.error.ErrorCodeHandler;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.CustomerInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;

public interface ICustomerInfoService extends BaseService<CustomerInfo> {

    CustomerInfo getCustomerByMobile(String mobile);

    CustomerInfo getCustomerByMobile(String mobile,boolean activated);

    CustomerInfo getCustomerByEmail(String email);

    CustomerInfo getCustomerByEmail(String email, boolean activated);
    //根据手机创建
    ResponseWrapper createCustomerByMobile(Map<String,Object> params,ErrorCodeHandler handler) throws SQLException;
    //根据邮箱创建
    ResponseWrapper createCustomerByEmail(String email, String password,String pwdStrong,ErrorCodeHandler handler) throws SQLException;
    //根据账号查询用户信息(email,mobile)
    CustomerInfo getCustomerByUserName(String userName, boolean activated);
    //获取用户登录信息
    ResponseWrapper getForLogin(CustomerInfo customerInfo, HttpServletRequest request, ResponseWrapper responseWrapper,ErrorCodeHandler handler);
    //验证用户身份是否过期
    CustomerInfo checkCurCustomer(String userid);
    //资金密码(设置、修改)
    ResponseWrapper resetAsset(Map<String, Object> paramToMap, HttpServletRequest request);
    //修改登录密码
    ResponseWrapper changePassword(Map<String, Object> paramToMap);
    //修改用户昵称
    ResponseWrapper updateCustomInfo(Map<String,Object> paramToMap);
    //找回密码-验证账号状态以及用户身份
    ResponseWrapper findPwdOne(Map<String,Object> param);
    //找回密码-验证身份
    ResponseWrapper findPwdTwo(Map<String,Object> param,HttpServletRequest request);
    //修改密码-StepOne
    ResponseWrapper changePwdOne(Map<String,Object> param);
    //修改密码-StepTwo
    ResponseWrapper changePwdTwo(Map<String,Object> param);

}
