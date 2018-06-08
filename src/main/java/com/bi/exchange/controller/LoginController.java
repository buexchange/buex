package com.bi.exchange.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.IAccountService;
import com.bi.exchange.service.ICustomerInfoService;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private ICustomerInfoService customerInfoService;

    @Autowired
    private IAccountService accountService;

    /**
     * 会员注册(手机或者邮箱)
     *  mobile      手机
     *  email       邮箱
     *  mcode       手机验证码
     *  ecode       邮箱验证码
     *  password    密码
     *  cfmpwd      确认密码
     **/
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public ResponseWrapper regCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> paramToMap = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        paramToMap.put("locale",map.get("locale"));
        return accountService.register(paramToMap, request, response);
    }

    /*
     * 找回密码-校验用户身份
     *  @param username   用户名
     *  @param mcode    短信验证码
     *  @param mtype    验证码类型
     **/
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/findPwdOne")
    public ResponseWrapper findPwdOne(HttpServletRequest request){
        Map<String,Object> paramToMap = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        paramToMap.put("locale",map.get("locale"));
        return customerInfoService.findPwdOne(paramToMap);
    }

    /*
     * 找回密码-重置密码
     * @param userid 用户ID
     * @param password  新密码
     * @param cmfpwd    确认密码
     **/
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/findPwdTwo")
    public ResponseWrapper findPwdTwo(HttpServletRequest request){
        Map<String,Object> paramToMap = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        paramToMap.put("locale",map.get("locale"));
        return customerInfoService.findPwdTwo(paramToMap,request);
    }

    /*
    * 发送验证码
    * @param mobile 手机号码
    * @param email 邮箱
    * @param type 验证类型
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/sendvcode")
    public ResponseWrapper sendVCode(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        return accountService.sendVCode(param);
    }

    /**
     *
     * 客户登录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseWrapper login(HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> params = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        params.put("locale", map.get("locale"));
        ResponseWrapper responseWrapper = accountService.userLogin(params, response, request);
        return responseWrapper;
    }

    /**
     * 登录(谷歌第二次验证)
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/oauth")
    public ResponseWrapper oauth(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> params = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        params.put("locale", map.get("locale"));
        ResponseWrapper responseWrapper = accountService.googleAuth(params,request,response);
        return responseWrapper;
    }

    /**
     * 客户登出
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value = "/loginOut")
    public ResponseWrapper loginOut(HttpServletResponse response,HttpServletRequest request){
        return accountService.loginOut(request, response);
    }
}
