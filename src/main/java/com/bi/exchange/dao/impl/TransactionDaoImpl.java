package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.ITransactionDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl extends BaseDaoImpl<Transaction> implements ITransactionDao {

    @Override
    public List<Transaction> transOrder(Long orderId, String type, String category) {
        String sql = "select * from s_" + category + "_tr where ";
        if (StringUtil.isNotBlank(type)) {
            sql += type + "_order_id = ?";
        } else {
            sql += " buy_order_id = ? or sell_order_id = ?";
            return getListBySql(sql, orderId, orderId);
        }
        return getListBySql(sql, orderId);
    }
}
