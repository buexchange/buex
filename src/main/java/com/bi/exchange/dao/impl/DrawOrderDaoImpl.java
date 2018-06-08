package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IDrawOrderDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.DrawOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DrawOrderDaoImpl extends BaseDaoImpl<DrawOrder> implements IDrawOrderDao {

    @Override
    public DrawOrder getByUserIdAndUpdateTime(Long userid, String updateTime) {
        StringBuilder sql = new StringBuilder("select * from ex_draw_order where deleted = '0' ");
        List<String> params = new ArrayList<>();
        if(StringUtil.isNotBlank(userid.toString())){
            sql.append(" and user_id = ?");
            params.add(userid.toString());
        }
        if(StringUtil.isNotBlank(updateTime)){
            sql.append(" and update_time = to_date('"+ updateTime +"','yyyy-MM-dd HH24:mi:ss')");
        }
        List<DrawOrder> drawOrders = getListBySql(sql.toString(), params);
        if(drawOrders.size() == 1){
            return drawOrders.get(0);
        }
        return null;
    }

    @Override
    public PageList<DrawOrder> getPageList(Page page, Map<String, Object> map) {
        String userid = StringUtil.getString(map.get("userid"));
        String startTime = StringUtil.getString(map.get("startTime"));
        String endTime = StringUtil.getString(map.get("endTime"));
        String assetCode = StringUtil.getString(map.get("assetCode"));
        List<String> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from ex_draw_order where deleted = 0");

        if(StringUtil.isNotBlank(userid)){
            sql.append(" and user_id = ?");
            params.add(userid);
        }
        if (StringUtil.isNotBlank(startTime)) {
            sql.append(" and create_time > to_date('"+ startTime +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if (StringUtil.isNotBlank(endTime)) {
            sql.append(" and create_time < to_date('"+ endTime +"','yyyy-MM-dd HH24:mi:ss')");
        }

        if (StringUtil.isNotBlank(assetCode)) {
            if(assetCode.indexOf(",")>0){
                sql.append(" and (");
                String[] acodeArr = assetCode.split(",");
                for(int i=0;i<acodeArr.length;i++){
                    if(StringUtil.isNotBlank(acodeArr[i])){
                        if(i==0)
                            sql.append(" asset_code=? ");
                        else
                            sql.append(" or asset_code=? ");
                        params.add(acodeArr[i]);
                    }
                }
                sql.append(")");
            }else{
                sql.append(" and asset_code=?");
                params.add(assetCode);
            }
        }
        sql.append(" order by create_time desc");
        return getPageListBySql(sql.toString(), page, params.toArray());
    }
}
