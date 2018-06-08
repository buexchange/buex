package com.bi.exchange.service;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.KLine;

import java.util.Map;

public interface IKLineService extends BaseService<KLine> {

    ResponseWrapper KlineProcess(Map<String,Object> params);

}
