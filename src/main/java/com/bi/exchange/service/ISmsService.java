package com.bi.exchange.service;


import com.bi.exchange.framework.web.response.ResponseWrapper;

import java.util.Map;

public interface ISmsService {

    //发送手机验证码
    ResponseWrapper sendMcode(Map<String, Object> paramToMap);
}
