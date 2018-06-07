package com.cp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.cp.domain.User;
import com.cp.utils.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * TODO 登陆处理
 *
 * @author liufeng
 * @create 2017/8/7 10:09
 */
public class ExtendFormAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(ExtendFormAuthenticationFilter.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        if (this.isLoginRequest(request, response)) {
            return false;
        }

        return super.isAccessAllowed(request, response, mappedValue) || this.isPermissive(mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }
            return true;
        }
        return this.forbidden(request, response);
    }

    //没有授权
    protected boolean forbidden(ServletRequest request, ServletResponse response) {
        ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ((HttpServletResponse) response).setContentType("application/json;charset=UTF-8");
        Result result = Result.createByErrorMessage("没有权限");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("userSession");

        Map map = Maps.newHashMap();
        map.put("access_token", subject.getSession().getId());
        map.put("user", user);
        Result result = Result.createBySuccess(map);
        response.setCharacterEncoding("UTF-8");
        ((HttpServletResponse) response).setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String message = e.getClass().getSimpleName();
        Result result = Result.createByError();
        if ("IncorrectCredentialsException".equals(message)) {
            result = Result.createByErrorMessage("密码错误");
        } else if ("UnknownAccountException".equals(message)) {
            result = Result.createByErrorMessage("账号不存在");
        } else if ("LockedAccountException".equals(message)) {
            result = Result.createByErrorMessage("账号被锁定");
        } else {
            result = Result.createByErrorMessage("未知错误");
        }

        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return false;
    }
}
