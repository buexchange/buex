package com.bi.exchange.service;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.BankInfo;

import java.util.Map;

public interface IBankInfoService extends BaseService<BankInfo> {

    //绑定银行卡
    ResponseWrapper insertBankInfo(BankInfo bankInfo,Map<String,String> map);
    //修改银行卡为默认
    ResponseWrapper updateBankInfoDefault(Map<String,Object> param);
    //删除银行卡
    ResponseWrapper deleteBankInfo(Map<String,Object> param);
    //根据银行卡号获取银行卡信息
    BankInfo getBankInfoByAccount(String bankAccount);
    //分页查询某用户银行卡列表
    PageList<BankInfo> getBanInfoByPage(Page page,Map<String,Object> map);

}
