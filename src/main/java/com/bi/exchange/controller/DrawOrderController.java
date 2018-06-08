package com.bi.exchange.controller;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.IDrawOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping(value = "/drawOrder")
public class DrawOrderController extends BaseController {

    @Autowired
    private IDrawOrderService drawOrderService;

    /**
     * 创建提现订单(账户提现,人民币或btc)
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/createDrawOrder")
    public ResponseWrapper createDrawOrder(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return drawOrderService.createDrawOrder(param,request);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getFeeList")
    public ResponseWrapper getFeeList(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return drawOrderService.getFeeList(param);
    }

    /**
     * 分页查询提现订单
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/drawOrderRecord")
    public ResponseWrapper drawOrderPageList(Page page,HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        return drawOrderService.getPageList(page, param);
    }

}
