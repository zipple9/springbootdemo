package com.wzy.demo.Security;

import com.wzy.demo.Model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.servlet.http.HttpSession;

/**
 * Created by wzy on 2018/10/22 17:39
 *
 * 这个类是鉴权和授权模块
 *
 *
 **/
public final class SessionManager {




    public static boolean isAuthenticated(final HttpSession session) {
        SecurityContext securityContext = readSecurityContextFromSession(session);
        if (securityContext == null || securityContext.getAuthentication() == null)
            return false;

        return securityContext.getAuthentication().isAuthenticated();
    }


    public static User getCurrentUser(final HttpSession session){
        SecurityContext sctx= readSecurityContextFromSession(session);
        if (sctx == null)
            return null;
        /**
         *  Authentication是一个接口，用来表示用户认证信息的，在用户登录认证之前相关信息会封装为一个Authentication具体实现类的对象，在登录认证成功之后又会生成一个信息更全面，包含用户权限等信息的Authentication对象，然后把它保存在SecurityContextHolder所持有的SecurityContext中，供后续的程序进行调用，如访问权限的鉴定等。
         *
         *  这里是从sctx中拿到authentication
         */
        Authentication auth = sctx.getAuthentication();
        if (null == auth)
            return null;

        if (!(auth.getPrincipal() instanceof User)) {
            return null;
        }

        return (User) auth.getPrincipal();

    }

    public static Authentication getAuthentication(final HttpSession session) {
        SecurityContext securityContext = readSecurityContextFromSession(session);
        if (securityContext == null)
            return null;

        Authentication auth = securityContext.getAuthentication();
        if (null == auth)
            return null;

        return auth;
    }

    private static SecurityContext readSecurityContextFromSession(final HttpSession session){
        /**SecurityContextRepository 这个接口用于加载和储存security ctx    下面的是其实现类

         最后转换类型为sctx 返回
         */
        Object contextFromSession = session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);

        if (contextFromSession == null)
            return null;

        if (!(contextFromSession instanceof SecurityContext))
            return null;

        return (SecurityContext) contextFromSession;

    }  //从session中拿到security ctx

    public static void destroySession(final HttpSession session) {
        session.removeAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        session.invalidate();
    }// 销毁session

}
