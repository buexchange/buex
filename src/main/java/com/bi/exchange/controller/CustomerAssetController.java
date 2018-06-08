package com.bi.exchange.controller;

import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.ICustomerAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/customerAsset")
public class CustomerAssetController extends BaseController{

    @Autowired
    ICustomerAssetService customerAssetService;


    /**
     *
     * 人民币现货资产总览
     *
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/cnyAccount")
    public ResponseWrapper cnyAccount(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return customerAssetService.cnyAccount(param);
    }

    /**
     * 人民币现货资产
     */
    @RequestMapping(method = RequestMethod.POST,value = "/cnySpotAssetQuery")
    @ResponseBody
    public ResponseWrapper cnySpotAssetQuery(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }

        return customerAssetService.queryCustomerAssert(param);
    }

    @ResponseBody
    @RequestMapping(value = "/assetTransfer",method = RequestMethod.POST)
    public ResponseWrapper assetTransfer(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return customerAssetService.assetTransfer(param);
    }

}
