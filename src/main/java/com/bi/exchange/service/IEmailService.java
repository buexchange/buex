package com.bi.exchange.service;

import com.bi.exchange.framework.web.response.ResponseWrapper;

import java.util.Map;

public interface IEmailService {

    //验证邮箱验证码
    Boolean checkEcode(String email, String type, String code);
    //发送邮箱验证码
    ResponseWrapper sendEcode(Map<String, Object> paramToMap);
}
