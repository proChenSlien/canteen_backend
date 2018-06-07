package com.cp.security;

import com.cp.domain.Resource;
import com.cp.service.ResourceService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.WebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/27 15:14
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private ResourceService resourceService;



    @Bean
    public  static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     Filter Chain定义说明
     1、一个URL可以配置多个Filter，使用逗号分隔
     2、当设置多个过滤器时，全部验证通过，才视为通过
     3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.getFilters().put("custAuthc", authenticatingFilter());
        shiroFilterFactoryBean.getFilters().put("custPerms", permissionsFilter());
        // 如果不设置默认会自动寻找Web工程根目录下的'/login.jsp'页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登陆成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/main");
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/index", "anon");
//        filterChainDefinitionMap.put("/login", "anon");

        filterChainDefinitionMap.put("/*.html", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/*.jpg", "anon");


        filterChainDefinitionMap.put("/v2/api-docs/**","anon");
        filterChainDefinitionMap.put("/swagger-ui.html/**","anon");

        List<Resource> resourceList = resourceService.findAll();

        resourceList.forEach( resource -> {
            if (StringUtils.hasText(resource.getResource())){

                for (String res : resource.getResource().split(";")) {
                    String permission = "custPerms[" + res + "]";
                    filterChainDefinitionMap.put(res + "/**", permission);
                }

            }
        });
        filterChainDefinitionMap.put("/**", "custAuthc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }


//    @Bean
    public ExtendFormAuthenticationFilter authenticatingFilter(){
        return new ExtendFormAuthenticationFilter();
    }
//    @Bean
    public ExtendPermissionsAuthorizationFilter permissionsFilter(){
        return new ExtendPermissionsAuthorizationFilter();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(this.sessionManager());
        return securityManager;

    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return  myShiroRealm;
    }

    @Bean
    public WebSessionManager sessionManager(){
        return new SessionManager();
    }

    /**
     * 凭证匹配器,密码加密方式
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     *   所以我们需要修改下doGetAuthenticationInfo中的代码
     *  ）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(2); //2次md5
        return matcher;
    }


}
