package com.bi.exchange.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bi.exchange.Constants;
import com.bi.exchange.framework.cache.RedisCache;
import com.bi.exchange.framework.security.AbstractCurrentUser;
import com.bi.exchange.framework.security.userdetails.CurrentUser;
import com.bi.exchange.framework.util.AlgorithmUtil;
import com.bi.exchange.framework.util.PropertyReader;
import com.bi.exchange.framework.util.SecurityUtil;
import com.bi.exchange.framework.util.StringUtil;

/**
 * 处理前台登陆超时
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static int STATUS_NOT_LOGIN = 401;

    private static Logger logger = LogManager.getLogger(LoginInterceptor.class);

    /**
     * 请求controller 之前 验证用户是否登陆
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
    	boolean isLogin = false;
        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (CookieInfo.LOGIN_UUID_COOKIE_NAME.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();

                    cookieValue = AlgorithmUtil.decryptAESToString(cookieValue, Constants.UUID_AES_KEY);

                    if (StringUtil.isNotBlank(cookieValue)) {
                        RedisCache redisCache = RedisCache.getInstance();

                        String customerId = cookieValue.substring(cookieValue.lastIndexOf(StringUtil.COLON) + 1);

                        String key = CookieInfo.REDIS_COOKIE_CUSTOMER_PREFIX + customerId;

                        if (redisCache.existsCache(key)) {
                            isLogin = true;
                            Map<String, String> userMap = new HashMap<>();
                            userMap.put(CurrentUser.customerIdKey, customerId);
                            AbstractCurrentUser.addUserLocal(userMap);

                            // 重新延长两个小时
                            redisCache.expireKey(key, CookieInfo.LOGIN_EXPIRE_TIME);
                        }
                    }
                }
            }
        }else{
            if(checkLoginFromHeader(request)){
                isLogin = true;
            }
        }
        if (!isLogin) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(STATUS_NOT_LOGIN);
            } catch (Exception e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }

            if (SecurityUtil.isAjaxRequest(request)) {
                try {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(STATUS_NOT_LOGIN);
                } catch (Exception e) {
                    logger.error(ExceptionUtils.getStackTrace(e));
                }
            } else {
                String path = request.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
//                String targetUrl = basePath + request.getRequestURI();
                response.sendRedirect(basePath);
            }

            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        AbstractCurrentUser.removeUserLocal();
    }
    
    /**
     *  如果从cookie中获取不到_uuid,则从head中获取，如果有则表明已登录
     */
    private boolean checkLoginFromHeader(HttpServletRequest request){
        String userUuid = null;
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = String.valueOf(headerNames.nextElement());
            if("_uuid".equals(key)){
                userUuid = request.getHeader(key);
                break;
            }
        }
        System.out.println("cookie is null .... start get useruuid from header..." + request.getRequestURI() + userUuid);
        if(StringUtil.isNotBlank(userUuid)){
            String cacheKey = CookieInfo.REDIS_COOKIE_CUSTOMER_PREFIX + userUuid;
            RedisCache redisCache = RedisCache.getInstance();

            if (redisCache.existsCache(cacheKey)) {
                Map<String, String> userMap = new HashMap<>();
                userMap.put(CurrentUser.customerIdKey, userUuid);
                AbstractCurrentUser.addUserLocal(userMap);

                // 重新延长两个小时
                redisCache.expireKey(cacheKey, CookieInfo.LOGIN_EXPIRE_TIME);
                return true;
            }
        }
        return false;
    }
}
