package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ISafeCodeDao;
import com.bi.exchange.framework.dao.impl.BaseDaoForBuexImpl;
import com.bi.exchange.model.SafeCode;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SafeCodeDaoImpl extends BaseDaoForBuexImpl<SafeCode> implements ISafeCodeDao {

	@Override
	public SafeCode findBiSafecode(String skey) {
		String sql="SELECT * from BIT_SAFECODE WHERE SKEY=?";
		List<SafeCode> list = getListBySql(sql,skey);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updateBiSafecodeSceneId(String sceneId, String skey) {
		String sql="update BIT_SAFECODE set SCENEID=?,SCANTIME=sysdate WHERE SKEY=?";
		execUpdate(sql,sceneId,skey);
	}

}
