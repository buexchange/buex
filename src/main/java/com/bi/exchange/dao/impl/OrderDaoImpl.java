package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IOrderDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.DateUtil;
import com.bi.exchange.framework.util.Misc;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.Order;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order> implements IOrderDao {

    @Override
    public Connection getConnection() throws SQLException {
        return getJdbcTemplate().getDataSource().getConnection();
    }


    @Override
    public Order getById(Long userid, String category) {
        String sql = "select * from s_" + category + "_oing where id = ? and deleted = '0'";
        List<Map<String, Object>> orderList = getJdbcTemplate().queryForList(sql.toString(), userid);
        if (orderList.size() > 0) {
            return mapRow(orderList.get(0));
        }
        return null;
    }

    @Override
    public Order getByUserId(Long userid, String id, String tableName) {
        String sql = "select * from " + tableName + " where user_id = ? and id = ? and deleted = '0'";
        List<Order> listBySql = getListBySql(sql, userid, id);
        if (listBySql.size() > 0) {
            return listBySql.get(0);
        }
        return null;
    }

    @Override
    public int saveOrder(Order order, String tableName, Connection connection) throws SQLException {
        String sql = "insert into " + tableName + " (id, user_id, price, amount, freeze_amt, remain_freeze_amt, " +
                "order_time, order_status, trade_type, avg_price, real_amount, deleted, is_jump_queue,create_user, " +
                "update_user,make_market) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        //System.out.println(sql);
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            int i = 0;
            ps.setLong(++i, order.getId());
            ps.setLong(++i, order.getUserid());
            ps.setBigDecimal(++i, order.getPrice());
            ps.setBigDecimal(++i, order.getAmount());
            ps.setBigDecimal(++i, order.getFreezeAmt());
            ps.setBigDecimal(++i, order.getRemainFreezeAmt());
            ps.setLong(++i,order.getOrderTime());
            ps.setString(++i, order.getOrderStatus());
            ps.setString(++i, order.getTradeType());
            ps.setBigDecimal(++i, order.getAvgPrice());
            ps.setBigDecimal(++i, order.getRealAmount());
            ps.setString(++i, order.getDeleted());
            ps.setString(++i, order.getIsJumpQueue());
            ps.setString(++i, order.getCreateUser());
            ps.setString(++i, order.getUpdateUser());
            ps.setInt(++i, order.getMakeMarket());
            return ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public Map getAskByid(String category) {
        Map<String, BigDecimal> resultMap = new HashMap<>();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, -1);
        String tempTime = DateUtil.convertToString(c.getTime(), DateUtil.YYYY_MM_DD_HH_MM_SS);
        String sql = "select * from s_" + category + "_oing where deleted = '0' and trade_type = 'buy' and make_market <> 1 and order_status = 0 and create_time >= to_date('"+ tempTime +"','yyyy-MM-dd HH24:mi:ss') order by price desc";
        List<Order> listBySql = getListBySql(sql);
        if (listBySql.size() > 0) {
            resultMap.put("buy", listBySql.get(0).getPrice());
        }
        sql = "select * from s_" + category + "_oing where deleted = '0' and trade_type = 'sell' and make_market <> 1 and order_status = 0 and create_time >= to_date('"+ tempTime +"','yyyy-MM-dd HH24:mi:ss') order by price";
        listBySql = getListBySql(sql);
        if (listBySql.size() > 0) {
            resultMap.put("sell", listBySql.get(0).getPrice());
        }
        return resultMap;
    }

    @Override
    public Order getOrder(String id, String tableName) {
        String sql = "select * from " + tableName + " where id = ? and deleted = '0'";
        try{
        	List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, id);
        	List<Order> orderList = new ArrayList<Order>();
        	if (list.size() > 0) {
                for (Map<String, Object> map : list) {
                	orderList.add(mapRow(map));
                }
            }
        	
        	if(orderList!=null && orderList.size()>0){
        		return orderList.get(0);
        	}
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


	/**
     * 撤销挂单
     */
    @Override
    public int revokeOrderInfo(String id, String category, Connection connection) throws SQLException {
        String sql = "update s_" + category + "_oing set order_status = 4 where id = ? and (order_status = 0 or order_status = 1) and deleted = '0'";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * 撤销挂单
     */
    @Override
    public int revokeOrder(String id, String tableName, Connection connection) throws SQLException {
        String sql = "update " + tableName + " set order_status = 4 where id = ? and (order_status = 0 or order_status = 1) and deleted = '0'";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public PageList<Order> getRecordList(Page page, String userid, String tableName,String orderType) {

        int pageNo = page.getPageNo();
        int pageSize = page.getPageSize();
        String sql = "select * from (select A.*, ROWNUM RN from (select * " +
                " from "+tableName+" where deleted = '0' and user_id = ? ";
        if(StringUtil.isNotBlank(orderType)){
            sql += "and trade_type = '"+orderType+"'";
        }
        sql+="and (order_status = -1 or order_status = 2) order by update_time desc, create_time desc) A" +
                " where ROWNUM <= "+pageNo*pageSize+" ) where RN > "+(pageNo-1)*pageSize+" ";
        String countSql = "select COUNT(*) from "+tableName+" where deleted = '0' and user_id = ? " +
                "and (order_status = -1 or order_status = 2)";
        PageList<Order> pageList = new PageList<>();
        List<Order> list = new ArrayList<>();
    	List<Map<String, Object>> orderList = getJdbcTemplate().queryForList(sql, userid);
    	if (orderList.size() > 0) {
            for (Map<String, Object> map : orderList) {
            	list.add(mapRow(map));
            }
        }
        Integer count = getJdbcTemplate().queryForObject(countSql, Integer.class,userid);

        pageList.setResultList(list);
        pageList.setTotalCount(count);
        pageList.setPage(page);
        if(pageList.getTotalPages()>pageNo)
            pageList.setHasNext(true);
        return pageList;
    }

    //挂单列表
    public PageList<Order> getPageList(Page page, Map<String, Object> param, String tableName) {
        int pageNo = page.getPageNo();
        int pageSize = page.getPageSize();
        String userid = StringUtil.getString(param.get("userid"));
        String type = StringUtil.getString(param.get("type"));
        StringBuilder sql = new StringBuilder("select * from (select A.*, ROWNUM RN from ( " +
                "select * " +
                " from "+tableName+" where deleted = '0'");
        StringBuilder countSql = new StringBuilder("select COUNT(*) from "+tableName+" where deleted = '0' ");
        if (StringUtil.isNotBlank(userid)) {
            sql.append(" and user_id = ? ");
            countSql.append(" and user_id = ? ");
        }

        if (StringUtil.isNotBlank(type)) {
            if (StringUtil.equals("ordering", type)) {
                sql.append(" and (order_status = 0 or order_status = 1) and (trade_type = 'buy' or trade_type  = 'sell')");
                countSql.append(" and (order_status = 0 or order_status = 1) and (trade_type = 'buy' or trade_type  = 'sell')");
            } else {
                sql.append(" and (order_status = -1 or order_status = 2) ");
                countSql.append(" and (order_status = -1 or order_status = 2) ");
            }
        }
        sql.append("order by UPDATE_TIME DESC, CREATE_TIME desc) A" +
                " where ROWNUM <= "+pageNo*pageSize+" ) where RN > "+(pageNo-1)*pageSize+" ");
        PageList<Order> pageList = new PageList<>();
        List<Order> list = new ArrayList<>();
        List<Map<String, Object>> orderList = getJdbcTemplate().queryForList(sql.toString(), userid);
        if (orderList.size() > 0) {
            for (Map<String, Object> map : orderList) {
                list.add(mapRow(map));
            }
        }
        Integer count = getJdbcTemplate().queryForObject(countSql.toString(), Integer.class,userid);

        pageList.setResultList(list);
        pageList.setTotalCount(count);
        pageList.setPage(page);
        if(pageList.getTotalPages()>pageNo)
            pageList.setHasNext(true);
        return pageList;
    }

    @Override
    public PageList<Order> getOrderingList(Page page, Map<String, Object> param, String ordringTableName,String tableName,String orderType) {
        try{
            int pageNo = page.getPageNo();
            int pageSize = page.getPageSize();
            String userid = StringUtil.getString(param.get("userid"));
            StringBuffer sql = new StringBuffer("SELECT * FROM ( SELECT ROW_.*, ROWNUM ROWNUM_ FROM ( ");
                sql.append("select o.* from ");
                sql.append(ordringTableName)
                    .append(" oing left join ")
                    .append(tableName)
                    .append(" o on oing.id=o.id where oing.user_id=? ");
                if(StringUtil.isNotBlank(orderType)){
                    sql.append("and o.trade_type = '"+orderType+"' ");
                }
                sql.append("order by oing.id desc")
                        .append(") ROW_  WHERE ROWNUM <= "+pageNo*pageSize+" ) WHERE ROWNUM_ >"+(pageNo-1)*pageSize);

            StringBuffer countSql = new StringBuffer("select COUNT(*) from "+ordringTableName+" where user_id = ? ");
            if(StringUtil.isNotBlank(orderType)){
                countSql.append("and trade_type = '"+orderType+"' ");
            }
            Integer count = getJdbcTemplate().queryForObject(countSql.toString(), Integer.class,userid);

            PageList<Order> pageList = new PageList<>();
            List<Order> list = new ArrayList<>();
            List<Map<String, Object>> orderList = getJdbcTemplate().queryForList(sql.toString(), userid);
            if (orderList.size() > 0) {
                for (Map<String, Object> map : orderList) {
                    list.add(mapRow(map));
                }
            }
            pageList.setResultList(list);
            pageList.setTotalCount(count);//当前委托不分页，所以这里先写死防止解析json报错
            pageList.setPage(page);
            if(pageList.getTotalPages()>pageNo)
                pageList.setHasNext(true);
            return pageList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Order mapRow(Map<String, Object> map) {
    	Order order = new Order();
    	order.setId(Misc.parseLong(map.get("ID").toString()));
        order.setUserid(Misc.parseLong(map.get("USER_ID").toString()));
        order.setPrice((BigDecimal)map.get("PRICE"));
        order.setPriceStr(((BigDecimal) map.get("PRICE")).toPlainString());
        order.setAmount((BigDecimal)map.get("AMOUNT"));
        order.setFreezeAmt((BigDecimal)map.get("FREEZE_AMT"));
        order.setRemainFreezeAmt((BigDecimal)map.get("REMAIN_FREEZE_AMT"));
        order.setOrderTime(Misc.parseLong(map.get("ORDER_TIME").toString()));
        order.setOrderStatus(map.get("ORDER_STATUS").toString());
        order.setTradeType((String)map.get("TRADE_TYPE"));
        order.setAvgPrice((BigDecimal)map.get("AVG_PRICE"));
        order.setRealAmount((BigDecimal)map.get("REAL_AMOUNT"));
        order.setIsJumpQueue((String)map.get("IS_JUMP_QUEUE"));
        order.setMakeMarket(Misc.parseInteger(map.get("MAKE_MARKET").toString()));
		return order;
	}
}
