package com.bi.exchange.controller;

import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.service.IKLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class KLineController extends BaseController {

    @Autowired
    private IKLineService klineService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/klineProcess")
    public ResponseWrapper KlineProcess(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        return klineService.KlineProcess(param);
    }

}
