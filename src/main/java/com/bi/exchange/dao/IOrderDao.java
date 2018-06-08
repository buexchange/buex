package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.model.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public interface IOrderDao extends BaseDao<Order> {

    Connection getConnection() throws SQLException;

    Order getById(Long id, String category);

    Order getByUserId(Long userid, String id, String tableName);

    int saveOrder(Order order, String tableName, Connection connection) throws SQLException;

    Map getAskByid(String category);

    Order getOrder(String id, String tableName);

    int revokeOrderInfo(String id, String category, Connection connection) throws SQLException;

    int revokeOrder(String id, String tableName, Connection connection) throws SQLException;

    PageList<Order> getRecordList(Page page,String userid,String tableName,String orderType);

    PageList<Order> getPageList(Page page,Map<String,Object> map,String tableName);

    PageList<Order> getOrderingList(Page page,Map<String, Object> param, String ordringTableName,String tableName,String orderType);

}
