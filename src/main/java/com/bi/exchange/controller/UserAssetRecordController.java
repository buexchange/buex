package com.bi.exchange.controller;

import com.bi.exchange.framework.page.Page;
import com.bi.exchange.framework.page.PageList;
import com.bi.exchange.framework.util.ResponseUtils;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.model.UserAssetRecord;
import com.bi.exchange.service.IUserAssetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/userAssetRecord")
public class UserAssetRecordController extends BaseController {

    @Autowired
    private IUserAssetRecordService userAssetRecordService;


    /**
     *  账单明细-根据类型(分页)
     * @param page
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/historyList")
    public ResponseWrapper getPageListByUserId(Page page, HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        if (CookieInfo.getCustomerIdByCookie(request) != null) {
            param.put("userid", CookieInfo.getCustomerIdByCookie(request));
        }

        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }

        PageList<UserAssetRecord> pageList = userAssetRecordService.getPageListByType(page, param);
        return ResponseUtils.successResponse("list", pageList, "查询完成");
    }
}
