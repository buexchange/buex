package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IWalletInfoDao;
import com.bi.exchange.enumUtil.WalletTypeEnum;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.model.WalletInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class WalletInfoDaoImpl extends BaseDaoImpl<WalletInfo> implements IWalletInfoDao {

    @Override
    public WalletInfo getWalletByType(Long userid, String walletType, String assetCode) {
        String sql = "select * from ex_wallet_info where user_id = ? and wallet_type = ? and asset_code = ? and deleted = '0'";
        List<WalletInfo> list = getListBySql(sql, userid, walletType, assetCode);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageList<WalletInfo> getPageList(Page page, Map<String, Object> param) {
        String userid = StringUtil.getString(param.get("userid"));
        String startTime = StringUtil.getString(param.get("startTime"));
        String endTime = StringUtil.getString(param.get("endTime"));
        String assetCode = StringUtil.getString(param.get("assetCode"));
        List<String> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from ex_wallet_info where deleted = 0");
        if(StringUtil.isNotBlank(userid)) {
            sql.append(" and USER_ID = ?");
            params.add(userid);
        }
        if (StringUtil.isNotBlank(startTime)) {
            sql.append(" and CREATE_TIME >= to_date('"+ startTime +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if (StringUtil.isNotBlank(endTime)) {
            sql.append(" and CREATE_TIME < to_date('"+ endTime +"','yyyy-MM-dd HH24:mi:ss')");
        }
        if(StringUtil.isNotBlank(assetCode)){
            sql.append(" and ASSET_CODE = ?");
            params.add(assetCode);
        }
        sql.append(" and WALLET_TYPE=?");
        params.add(WalletTypeEnum.drawals.name());  //设置类型为提现
        sql.append(" order by CREATE_TIME desc");
        return getPageListBySqlWithNext(sql.toString(), page, params);
    }

    @Override
    public List<WalletInfo> getListByDigitAssetAddress(String digitAssetAddress, Long userid) {
        String sql = "select * from ex_wallet_info where deleted = 0 and DIGIT_ASSET_ADDRE = ? and USER_ID = ?";
        return getListBySql(sql, digitAssetAddress,userid);
    }
}
