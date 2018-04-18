package com.elies.base.common;


import com.alibaba.fastjson.JSON;
import com.elies.base.constant.Constant;
import com.elies.base.constant.ResponseMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 牟雪
 * @since 2018/4/18
 */
public class InterceptorUtil implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(InterceptorUtil.class);
    @Autowired
    RedisService redisService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        if(!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            String sessionId = request.getHeader("sessionId");
            if(StringUtils.isBlank(sessionId)) {
                sessionId = request.getParameter("sessionId");
            }

            if(StringUtils.isBlank(sessionId)) {
                this.writeMessage(response);
                return false;
            } else {
                String sessionInfo = redisService.get("JSESSIONID:" + sessionId);
                if(null == sessionInfo) {
                    return this.writeTimeOut(response);
                } else {
                    redisService.expire("JSESSIONID:" + sessionId, Constant.SESSION_EXPIRE.intValue());
                    return true;
                }
            }
        }
    }

    private void writeMessage(HttpServletResponse res) throws IOException {
        ResponseUtil result = ResponseUtil.fail(ResponseMessage.PARAM_ERROR.getCode(), ResponseMessage.PARAM_ERROR.getMessage());
        res.getWriter().write(JSON.toJSONString(result));
        res.getWriter().flush();
    }

    private boolean writeTimeOut(HttpServletResponse res) throws IOException {
        ResponseUtil result = ResponseUtil.fail(ResponseMessage.SESSION_TIMEOUT.getCode(), ResponseMessage.SESSION_TIMEOUT.getMessage());
        res.getWriter().write(JSON.toJSONString(result));
        res.getWriter().flush();
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
