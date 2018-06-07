package com.cp.security;

import com.alibaba.druid.support.json.JSONUtils;
import com.cp.utils.Result;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/8/9 11:10
 */
public class ExtendPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            WebUtils.toHttp(response).sendError(401);
        } else {
            WebUtils.toHttp(response).setHeader("Content-Type","application/json;charset=UTF-8");
            WebUtils.toHttp(response).getWriter().write(JSONUtils.toJSONString(Result.createByErrorMessage("禁止访问")));
        }

        return false;
    }
}
