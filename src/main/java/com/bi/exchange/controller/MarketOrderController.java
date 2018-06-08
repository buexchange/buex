package com.bi.exchange.controller;

import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MarketOrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    /**
     * 做市挂单接口 Demo版
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/inorder/testorder")
    public ResponseWrapper getOrderByTest(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        return orderService.orderByTest(param);
    }
}
