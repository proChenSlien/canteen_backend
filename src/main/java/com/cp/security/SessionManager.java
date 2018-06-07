package com.cp.security;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/8/3 17:13
 */
public class SessionManager extends DefaultWebSessionManager{

    private String authorization = "Authorization";

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        Serializable id =  super.getSessionId(request, response);
        if (id == null){
            id = WebUtils.toHttp(request).getHeader(this.authorization);
        }
        return id;
    }
}
