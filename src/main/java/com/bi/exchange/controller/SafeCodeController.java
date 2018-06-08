package com.bi.exchange.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bi.exchange.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.ISafeCodeService;

/**
 * 短信验证码或邮箱验证码接口
 * @author wangbl
 *
 */
@Controller
public class SafeCodeController extends BaseController {
	
	@Autowired
	private ISafeCodeService safeCodeService;
	
	/*
    * 发送验证码  需要用户身份
    * @param mobile 手机号码
    * @param email 邮箱
    * @param type 验证类型
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/sendVCode")
    public ResponseWrapper sendVCode(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return safeCodeService.sendVCode(request,param);
    }
    
    /*
     * 发送验证码 注册、忘记密码,绑定新手机
     * @param mobile 手机号码
     * @param email 邮箱
     * @param type 验证类型
     * */
     @ResponseBody
     @RequestMapping(method = RequestMethod.POST, value = "/sendRegCode")
     public ResponseWrapper sendRegCode(HttpServletRequest request) {
         Map<String, Object> param = convertParamToMap(request);
         Map<String,String> map = CookieInfo.getCookiesInfo(request);
         param.put("locale",map.get("locale"));
         return safeCodeService.sendRegCode(request,param);
     }
}
