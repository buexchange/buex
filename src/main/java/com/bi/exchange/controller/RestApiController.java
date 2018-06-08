package com.bi.exchange.controller;

import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.service.IRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
public class RestApiController extends BaseController {

    @Autowired
    private IRestApiService restApiService;

    @ResponseBody
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public ResponseWrapper resetPassword(HttpServletRequest request){
        Map<String,Object> map = convertParamToMap(request);
        return restApiService.resetPassword(map);
    }

    @ResponseBody
    @RequestMapping(value = "/resetFundPwd",method = RequestMethod.POST)
    public ResponseWrapper resetFundPwd(HttpServletRequest request){
        Map<String,Object> map = convertParamToMap(request);
        return restApiService.resetFundPwd(map);
    }

    @ResponseBody
    @RequestMapping(value = "/resetGoogle",method = RequestMethod.POST)
    public ResponseWrapper resetGoogle(HttpServletRequest request){
        Map<String,Object> map = convertParamToMap(request);
        return restApiService.resetGoogle(map);
    }

}
