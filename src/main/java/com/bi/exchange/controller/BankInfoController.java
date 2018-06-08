package com.bi.exchange.controller;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.ResponseUtils;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.model.BankInfo;
import com.bi.exchange.service.IBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/bankInfo")
public class BankInfoController extends BaseController{

    @Autowired
    private IBankInfoService bankInfoService;



    /**
     * 添加银行卡
     * @param bankInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public ResponseWrapper bankInfoBinding(BankInfo bankInfo, HttpServletRequest request) {
        Map<String,String> param = CookieInfo.getCookiesInfo(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            map.put("ex_token",_token);
        }
        return bankInfoService.insertBankInfo(bankInfo,param);
    }

    /**
     * 根据id设置银行卡为默认
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/default")
    public ResponseWrapper updateBankInfoDefault(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("ex_token",_token);
        }
        return bankInfoService.updateBankInfoDefault(param);
    }

    /**
     * 删除银行卡
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public ResponseWrapper deleteBankInfo(HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));

        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("ex_token",_token);
        }
        return bankInfoService.deleteBankInfo(param);
    }

    /**
     * 获取用户银行卡列表(分页)
     * @param page
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getBankInfoByPage")
    public ResponseWrapper getBankInfoByPage(Page page,HttpServletRequest request){
        Map<String,Object> params = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        params.put("userid",map.get("userid"));
        params.put("locale",map.get("locale"));

        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            params.put("_token",_token);
        }

        PageList<BankInfo> pageList = bankInfoService.getBanInfoByPage(page,params);
        ResponseWrapper responseWrapper = ResponseUtils.successResponse("list",pageList,"查询完成");
        return responseWrapper;
    }

}
