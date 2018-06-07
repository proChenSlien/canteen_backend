package com.cp.security;

import com.cp.domain.User;
import com.cp.service.ResourceService;
import com.cp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * TODO realm
 *
 * @author liufeng
 * @create 2017/7/27 15:51
 */
public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("userSession");

        //权限对象info，用来存放查出的用户的所有角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        user.getRoles().forEach(u -> {
            u.getResources().forEach(resource -> {
                if (StringUtils.hasText(resource.getResource())) {
                    for (String s : resource.getResource().split(";")) {
                        info.addStringPermission(s);
                    }
                }
            });
        });

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的账号
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null) throw new UnknownAccountException();

        if (false == user.isEnabled()) {
            throw new LockedAccountException(); //账号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户
                user.getPassword(), //密码
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getId());

        return authenticationInfo;
    }
}
