package com.bi.exchange.controller;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.IDepositOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/depositOrder")
public class DepositOrderController extends BaseController {

    @Autowired
    private IDepositOrderService depositOrderService;

    /**
     * 账户充值接口
     * @return
     */
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST,value = "/deposit")
//    public ResponseWrapper createDepositOrder(DepositOrder depositOrder, HttpServletRequest request) {
//        Map<String,String> map = CookieInfo.getCookiesInfo(request);
//        String _token = CookieInfo.getTokenByHeader(request);
//        if(StringUtil.isNotBlank(_token)) {
//            map.put("_token", _token);
//        }
//        return depositOrderService.createDepositOrder(depositOrder,map);
//    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getDepositDetail")
    public ResponseWrapper getDepositDetail(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return depositOrderService.getDepositDetail(param);
    }

    /**
     * 分页查询充值记录(根据assetCode区分 btc eth)
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/depositRecord")
    public ResponseWrapper getDepositPageListByCode(Page page, HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return depositOrderService.getDepositPageList(page, param);
    }


}
