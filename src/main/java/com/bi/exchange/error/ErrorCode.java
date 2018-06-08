package com.bi.exchange.error;


import com.bi.exchange.framework.util.Misc;

public class ErrorCode {
    public static ErrorCodeHandler getInstance(String locale) {
        if(Misc.isStringEmpty(locale)){
            locale = "CN";//default simple chinese
        }
        ErrorCodeHandler handler = null ;
        if("CN".equals(locale))
            handler = ErrorCodeZh.getInstance();
        else if("US".equals(locale))
            handler = ErrorCodeEn.getInstance();
        return handler ;
    }
}
