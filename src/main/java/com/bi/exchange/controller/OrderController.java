package com.bi.exchange.controller;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController{

    @Autowired
    private IOrderService orderService;

    /*
    * 通过订单id查询订单接口
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getOrderById")
    public ResponseWrapper getOrderById(HttpServletRequest request) {
       // Map<String,Object> param = convertParamToMap(request);
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.getOrderById(param);
    }

    /*
   * 内部 id 查找订单接口
   * return type,status,avgPrice,dealAmount
   * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/findOrderById")
    public ResponseWrapper findOrderById(HttpServletRequest request) {
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.findOrderById(param);
    }

    /*
   * 通过订单id查询订单未成交冻结金额(数量)接口
   * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getFreezeAmtById")
    public ResponseWrapper getFreezeAmtById(HttpServletRequest request) {
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.getFreezeAmtById(param);
    }

    /*
   * 内部挂单接口
   * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/inorder")
    public ResponseWrapper getOrderByAPI(HttpServletRequest request) {
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.orderByAPI(param);
    }

    /*
    * 交易所行情
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/ticker")
    public ResponseWrapper getTickerByAPI(HttpServletRequest request) {
        Map<String,Object> param = convertParamToMap(request);
        return orderService.getTickerByAPI(param);
    }

    /*
    * 挂单接口
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/createorder")
    public ResponseWrapper createOrder(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.createOrder(param);
    }

    /*
    * 撤单接口
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "revokeorder")
    public ResponseWrapper revokeOrder(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.revokeOrder(param);
    }

     /*
    * 批量撤单接口
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "batchrevoke")
    public ResponseWrapper batchRevoke(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.batchRevoke(param);
    }

    /*
    * 修改委托接口
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/change")
    public ResponseWrapper changeOrder(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }

        return orderService.changeOrder(param);
    }

    /*
   * 委托历史接口
   * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/recordList")
    public ResponseWrapper recordList(Page page, HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.getRecordList(page, param);
    }

    /*
     * 交易记录接口
     * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/list")
    public ResponseWrapper listOrder(Page page, HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid", map.get("userid"));
        param.put("locale", map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return orderService.getPageList(page, param);
    }



}
