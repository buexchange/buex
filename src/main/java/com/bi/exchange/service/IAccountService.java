package com.bi.exchange.service;



import com.bi.exchange.error.ErrorCodeHandler;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.CustomerInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public interface IAccountService{
    //用户注册（验证-创建）
    ResponseWrapper register(Map<String, Object> paramToMap, HttpServletRequest request, HttpServletResponse response) throws Exception;
    //验证码发送(邮箱或者手机)
    ResponseWrapper sendVCode(Map<String, Object> paramToMap);
    //会员登录方法
    ResponseWrapper userLogin(Map<String, Object> params, HttpServletResponse response, HttpServletRequest request);
    //谷歌二次验证
    ResponseWrapper googleAuth(Map<String,Object> params,HttpServletRequest request,HttpServletResponse response);
    //会员登出方法
    ResponseWrapper loginOut(HttpServletRequest request,HttpServletResponse response);
    //绑定手机，邮箱
    ResponseWrapper bindAccount(Map<String, Object> paramToMap, HttpServletRequest request);
    //验证手机验证码
    ResponseWrapper checkMcode(Long userid, String mobile, String code, String type, ErrorCodeHandler handler);
    //验证邮箱验证码
    ResponseWrapper checkEcode(String email, String ecode, String type,ErrorCodeHandler handler,HttpServletRequest request);
    //验证手机或邮箱验证码
    ResponseWrapper checkVcode(Map<String, Object> paramToMap,ErrorCodeHandler handler,HttpServletRequest request);
    //谷歌验证码验证
    ResponseWrapper checkToken(CustomerInfo customerInfo, String tokens,ErrorCodeHandler handler);
    //谷歌验证码验证
    ResponseWrapper checkToken(Map<String,Object> param,ErrorCodeHandler handler);
    //修改手机号码
    ResponseWrapper changeMobile(Map<String, Object> paramToMap, HttpServletRequest request);
    //谷歌验证器绑定
    ResponseWrapper gauthBind(Map<String, Object> paramToMap, HttpServletRequest request);
    //谷歌验证器修改
    ResponseWrapper changeGbind(Map<String, Object> paramToMap, HttpServletRequest request);
    //获取用户认证信息
    ResponseWrapper getAuth(Map<String,Object> param);
    //谷歌验证信息生成
    ResponseWrapper gauthGene(Map<String, Object> paramToMap, HttpServletRequest request);
    //谷歌验证器关闭
    ResponseWrapper gauthClose(Map<String,Object> paramToMap,HttpServletRequest request);
    //获取用户认证信息
    ResponseWrapper getInfo(Map<String,Object> param);
}
