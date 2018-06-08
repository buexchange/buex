package com.bi.exchange.controller;

import com.bi.exchange.framework.util.ResponseUtils;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.vo.VSymbol;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController extends BaseController{

    /**
     * 场外币种信息
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/buexSymbol")
    public ResponseWrapper buexSymbol(){
        List<VSymbol> list = new ArrayList<>();
        list.add(new VSymbol("BTC"));
        list.add(new VSymbol("ETH"));
        ResponseWrapper responseWrapper = ResponseUtils.successResponse("");
        responseWrapper.addAttribute("symbol",list);
        return responseWrapper;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/exchangeSymbol")
    public ResponseWrapper exchangeSymbol(){
        List<VSymbol> list = new ArrayList<>();
        list.add(new VSymbol("BTC"));
        list.add(new VSymbol("ETH"));
        list.add(new VSymbol("BSS"));
        ResponseWrapper responseWrapper = ResponseUtils.successResponse("");
        responseWrapper.addAttribute("symbol",list);
        return responseWrapper;
    }


}
