package com.bi.exchange.service;

import java.util.Date;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.model.SmsTask;

public interface ISmsTaskService extends BaseService<SmsTask> {

	Date getLastCreatetimeByMobile(String mobile);
	

}
