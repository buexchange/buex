package com.bi.exchange.dao;

import com.bi.exchange.framework.dao.BaseDao;
import com.bi.exchange.model.Transaction;

import java.util.List;

public interface ITransactionDao extends BaseDao<Transaction> {

    List<Transaction> transOrder(Long orderId, String type, String category);

}
