package com.bi.exchange.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bi.exchange.framework.service.BaseService;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.model.SafeCode;

public interface ISafeCodeService extends BaseService<SafeCode> {

	/**
	 * 发送验证码 需要用户身份
	 * @param param
	 * @return
	 */
	ResponseWrapper sendVCode(HttpServletRequest request,Map<String, Object> param);
	
	/**
	 * 发送验证码  不需要用户身份
	 * @param param
	 * @return
	 */
	ResponseWrapper sendRegCode(HttpServletRequest request,Map<String, Object> param);

	/**
	 * 校验用户输入的 验证码
	 * @param userid
	 * @param functionName
	 * @param userSafeCode
	 * @param mobile
	 * @return 1:校验通过  0:不通过 -1:用户不存在  -2 异常: -3:用户输入信息不完整  -4:超时 请重新点击获取  -6:手机号码不对  -7:非法操作
	 */
	int checkSafeCode(Long userid,String functionName,String userSafeCode,String mobile);

	/**
	 * 使用过后 修改 skey 的状态
	 * @param userid
	 * @param functionName
	 * @param userSafeCode
	 * @param mobile
	 * @return
	 */
	boolean updateSafecodeStatus(Long userid,String functionName,String userSafeCode,String mobile);

}
