package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IDepositOrderDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.DepositOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DepositOrderDaoImpl extends BaseDaoImpl<DepositOrder> implements IDepositOrderDao{

    @Override
    public PageList<DepositOrder> getPageList(Page page, Map<String, Object> param) {

        String userid = StringUtil.getString(param.get("userid"));
        String assetCode = StringUtil.getString(param.get("assetCode"));
        String startTime = StringUtil.getString(param.get("startTime"));
        String endTime = StringUtil.getString(param.get("endTime"));
        StringBuilder sql = new StringBuilder("select * from ex_depositorder where 1=1 ");
        List<String> params = new ArrayList<>();
        if(StringUtil.isNotBlank(userid)){
            sql.append("and userid = ?");
            params.add(userid);
        }
        if (StringUtil.isNotBlank(startTime)) {
            sql.append(" and createtime > to_date('"+ startTime +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if (StringUtil.isNotBlank(endTime)) {
            sql.append(" and createtime < to_date('"+ endTime +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if (StringUtil.isNotBlank(assetCode)) {
            if(assetCode.indexOf(",")>0){
                sql.append(" and (");
                String[] acodeArr = assetCode.split(",");
                for(int i=0;i<acodeArr.length;i++){
                    if(StringUtil.isNotBlank(acodeArr[i])){
                        if(i==0)
                            sql.append(" assetcode= ? ");
                        else
                            sql.append(" or assetcode=? ");
                        params.add(acodeArr[i]);
                    }
                }
                sql.append(")");
            }else{
                sql.append(" and assetcode=?");
                params.add(assetCode.toLowerCase());
            }
        }
        sql.append(" order by createtime desc");
        return getPageListBySql(sql.toString(), page, params.toArray());
    }

    @Override
    public DepositOrder getDepositDetail(Long id) {
        String sql = "select * from ex_depositorder where id = ?";
        List<DepositOrder> list = getListBySql(sql,id);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
