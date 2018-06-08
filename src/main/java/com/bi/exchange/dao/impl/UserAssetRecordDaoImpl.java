package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IUserAssetRecordDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.UserAssetRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserAssetRecordDaoImpl extends BaseDaoImpl<UserAssetRecord> implements IUserAssetRecordDao {

    @Override
    public PageList<UserAssetRecord> getPageList(Page page, Map<String, Object> param, String type) {
        String userid = StringUtil.getString(param.get("userid"));
        String assetCode = StringUtil.getString(param.get("assetCode"));
        String startTime = StringUtil.getString(param.get("startTime"));
        String endTime = StringUtil.getString(param.get("endTime"));
        List<String> params = new ArrayList<>();
        StringBuffer start = null;
        StringBuffer end = null;
        if(StringUtil.isNotBlank(startTime)){
            start= new StringBuffer(startTime);
            start.append(" 00:00:00");
        }
        if(StringUtil.isNotBlank(endTime)){
            end= new StringBuffer(endTime);
            end.append(" 23:59:59");
        }
        StringBuilder sql = new StringBuilder("select * from ex_user_asset_record where deleted = '0'");
        sql.append(" and user_id = ?");
        params.add(userid);
        if (StringUtil.isNotBlank(start)) {
            sql.append(" and CREATE_TIME >= to_date('"+ start +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if (StringUtil.isNotBlank(end)) {
            sql.append(" and CREATE_TIME <= to_date('"+ end +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if (StringUtil.isNotBlank(type)) {
            sql.append(" and OPERATE_TYPE = ?");
            params.add(type);
        }
        if(StringUtil.isNoneBlank(assetCode)){
            sql.append(" and ASSET_CODE = ? ");
            params.add(assetCode);
        }
        sql.append(" order by id desc");
        return getPageListBySql(sql.toString(), page, params);
    }
}
