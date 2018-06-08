package com.bi.exchange.service;

import com.bi.exchange.framework.web.response.ResponseWrapper;

import java.util.Map;

public interface IRestApiService {

    ResponseWrapper resetPassword(Map<String,Object> params);

    ResponseWrapper resetFundPwd(Map<String,Object> params);

    ResponseWrapper resetGoogle(Map<String,Object> params);

}
