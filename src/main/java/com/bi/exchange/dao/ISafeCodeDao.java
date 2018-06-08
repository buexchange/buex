package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.SafeCode;

public interface ISafeCodeDao extends BaseDao<SafeCode> {

	SafeCode findBiSafecode(String skey);

	void updateBiSafecodeSceneId(String string, String skey);
}
