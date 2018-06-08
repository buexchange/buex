package com.bi.exchange.controller;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.util.Misc;
import com.bi.exchange.framework.util.ResponseUtils;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.model.WalletInfo;
import com.bi.exchange.service.IWalletInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/walletInfo")
public class WalletInfoController extends BaseController{

    @Autowired
    private IWalletInfoService walletInfoService;

    /**
     * 获取充币钱包地址（根据assetCode区分）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getByType")
    public ResponseWrapper getWalletByType(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return walletInfoService.getWalletByType(param, request);
    }

    /**
     * 分页查询提币钱包地址(以assetCode区分各币种)
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getWalletInfoPageList")
    public ResponseWrapper getWalletInfoPageList(Page page,HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return walletInfoService.getWalletPageList(page, param);
    }

    /**
     * 添加提币钱包地址（数字资产账户）
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public ResponseWrapper addWalletInfo(WalletInfo walletInfo, HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return walletInfoService.createWalletInfo(walletInfo, param,request);
    }

    /**
     * 删除提币钱包地址(数字资产账户)
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public ResponseWrapper deleteWalletInfo(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return walletInfoService.deleteWalletInfo(param);
    }
}
