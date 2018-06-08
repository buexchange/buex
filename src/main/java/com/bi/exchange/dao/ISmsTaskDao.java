package com.bi.exchange.dao;

import java.util.Date;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.SmsTask;

public interface ISmsTaskDao extends BaseDao<SmsTask> {

	Date getLastCreatetimeByMobile(String mobile);
}
