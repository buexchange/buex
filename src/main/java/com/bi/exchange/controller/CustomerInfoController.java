package com.bi.exchange.controller;

import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.ICustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/customerInfo")
public class CustomerInfoController extends BaseController{

    @Autowired
    private ICustomerInfoService customerInfoService;


    /*
     *  修改用户昵称
     * @param  username 用户昵称
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/changeInfo")
    public ResponseWrapper changeInfo(HttpServletRequest request){
        Map<String,Object> paramToMap = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        paramToMap.put("userid",map.get("userid"));
        paramToMap.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            paramToMap.put("_token",_token);
        }
        return customerInfoService.updateCustomInfo(paramToMap);
    }

}
