package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ISmsTaskDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.SmsTask;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class SmsTaskDaoImpl extends BaseDaoForBuexImpl<SmsTask> implements ISmsTaskDao{

	@Override
	public Date getLastCreatetimeByMobile(String mobile) {
		String sql = "select max(createtime) maxdate from bit_smstask where mobile=?";
		return getJdbcTemplate().queryForObject(sql, new String[]{mobile}, Date.class);
	}

}
