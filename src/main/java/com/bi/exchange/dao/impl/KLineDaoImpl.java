package com.bi.exchange.dao.impl;

import com.bi.exchange.dao.IKLineDao;
import com.bi.exchange.framework.dao.impl.BaseDaoImpl;
import com.bi.exchange.model.KLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KLineDaoImpl extends BaseDaoImpl<KLine> implements IKLineDao {

    @Override
    public List<KLine> selectKlineForPage(String tableName) {
        String sql = "SELECT * FROM (SELECT ROW_.*, ROWNUM ROWNUM_ FROM ( SELECT * FROM "+tableName+" ORDER BY SEQUENCE_ID DESC ) ROW_  WHERE ROWNUM <= 200) WHERE ROWNUM_ > 0";
        List<KLine> lineList = getListBySql(sql);
        if(lineList.size()>0){
            return lineList;
        }
        return null;
    }
}
