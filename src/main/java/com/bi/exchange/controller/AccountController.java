package com.bi.exchange.controller;

import com.bi.exchange.Constants;
import com.bi.exchange.framework.util.StringUtil;
import com.bi.exchange.framework.web.controller.BaseController;
import com.bi.exchange.framework.web.response.ResponseWrapper;
import com.bi.exchange.interceptor.CookieInfo;
import com.bi.exchange.service.IAccountService;
import com.bi.exchange.service.ICustomerIdentifyService;
import com.bi.exchange.service.ICustomerInfoService;
import com.bi.exchange.service.ICustomerSecurityPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController{

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICustomerIdentifyService customerIdentifyService;

    @Autowired
    private ICustomerInfoService customerInfoService;

    @Autowired
    private ICustomerSecurityPolicyService customerSecurityPolicyService;

    /**
     * 用户绑定(邮箱或手机)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/bind")
    public ResponseWrapper bind(HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        ResponseWrapper responseWrapper = accountService.bindAccount(param, request);
        if (responseWrapper.isSuccess()) {
            String type = StringUtil.getString(param.get("type"));
            if (Constants.SMS_CODE_TPYE_BIND.equals(type)) {
//                RabbitMqClient.sendScoreTaskMsg(userID, ScoreTaskEnum.bind_mobile.name(), null);
            } else if (Constants.EMAIL_CODE_TPYE_BIND.equals(type)) {
//                RabbitMqClient.sendScoreTaskMsg(userID, ScoreTaskEnum.bind_email.name(), null);
            }
        }
        return responseWrapper;
    }

    /**
     * 用户实名认证
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/identify")
    public ResponseWrapper identify(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        ResponseWrapper responseWrapper = customerIdentifyService.createByCode(param);
        if (responseWrapper.isSuccess()) {
//            RabbitMqClient.sendScoreTaskMsg(userid, ScoreTaskEnum.c1_auth.name(), null);
            String nickname = StringUtil.getString(param.get("nickname"));
            if (StringUtil.isNotBlank(nickname)) {
//                RabbitMqClient.sendScoreTaskMsg(userid, ScoreTaskEnum.set_nickname.name(), null);
            }
        }
        return  responseWrapper;
    }

    /**
     * 资金密码(设置、修改)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/resetasset")
    public ResponseWrapper assetReset(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        ResponseWrapper responseWrapper = customerInfoService.resetAsset(param, request);
        if (responseWrapper.isSuccess()) {
//            RabbitMqClient.sendScoreTaskMsg(userUuid, ScoreTaskEnum.set_asset_pwd.name(), null);
        }
        return responseWrapper;
    }

    /*
   * 修改登录密码
   * @param  oldpwd   旧密码
   * @param  password 新密码
   * @param  cfmpwd   确认密码
   *
   * */
    @RequestMapping(method = RequestMethod.POST, value = "/changepwd")
    @ResponseBody
    public ResponseWrapper changePassword(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return customerInfoService.changePassword(param);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/changePwdOne")
    public ResponseWrapper changePwdOne(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return customerInfoService.changePwdOne(param);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "changePwdTwo")
    public ResponseWrapper changPwdTwo(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return customerInfoService.changePwdTwo(param);
    }

    /*
   * 修改手机号码
   * @param omobile  原手机号码
   * @param ocode    原手机验证码
   * @param mobile   新手机号码
   * @param mcode    新手机验   证码
   * @param type     验证类型
   *
   * */
    @RequestMapping(method = RequestMethod.POST, value = "/changemobile")
    @ResponseBody
    public ResponseWrapper changeMobile(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return accountService.changeMobile(param, request);
    }

    /*
    * 安全策略设置
    * */
    @RequestMapping(method = RequestMethod.POST, value = "/setstrategy")
    @ResponseBody
    public ResponseWrapper setSecurity(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return customerSecurityPolicyService.setPolicyByMode(param, request);
    }

    /*
    * 谷歌验证器绑定信息生成
    * */
    @RequestMapping(method = RequestMethod.POST, value = "/gener")
    @ResponseBody
    public ResponseWrapper gauthGene(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return accountService.gauthGene(param, request);
    }

    /***
     * 谷歌验证器绑定
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/gbind")
    @ResponseBody
    public ResponseWrapper gauthBind(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        ResponseWrapper responseWrapper = accountService.gauthBind(param, request);
        if (responseWrapper.isSuccess()) {
//            RabbitMqClient.sendScoreTaskMsg(userUuid, ScoreTaskEnum.set_gauth.name(), null);
        }
        return responseWrapper;
    }

    /*
    * 修改谷歌验证器
    * @param mcode手机验证码
    * @param token 谷歌验验证码
    * @param secretKey 谷歌验证器密匙
    *
    * */
    @RequestMapping(method = RequestMethod.POST, value = "/chgbind")
    @ResponseBody
    public ResponseWrapper changeGbind(HttpServletRequest request) {
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return accountService.changeGbind(param, request);
    }

    /**
     * 关闭谷歌验证器
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/gclose")
    public ResponseWrapper gauthClose(HttpServletRequest request){
        Map<String,Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return accountService.gauthClose(param,request);
    }

     /*
    *  获取登录会员安全级别
    * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/auth")
    public ResponseWrapper getAuth(HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return accountService.getAuth(param);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getInfo")
    public ResponseWrapper getInfo(HttpServletRequest request){
        Map<String, Object> param = convertParamToMap(request);
        Map<String,String> map = CookieInfo.getCookiesInfo(request);
        param.put("userid",map.get("userid"));
        param.put("locale",map.get("locale"));
        String _token = CookieInfo.getTokenByHeader(request);
        if(StringUtil.isNotBlank(_token)){
            param.put("_token",_token);
        }
        return accountService.getInfo(param);
    }

}
