package com.bi.exchange.service;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.model.Transaction;

import java.util.List;

public interface ITransactionService extends BaseService<Transaction>{

    List<Transaction> transOrder(Long orderId, String type, String table_name);

}
