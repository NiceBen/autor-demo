package com.ofben.autordemo.config.shiro;

import com.ofben.autordemo.model.dto.CustomerModel;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录-单点登录-过滤器
 *
 * @date 2021-08-16
 * @since 1.0.0
 */
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        System.out.println("req.getRequestURI() : " + req.getRequestURI());
        if (req.getRequestURI().contains("toLogin") || req.getRequestURI().contains("login")) {
            chain.doFilter(request, response);
        } else {
            ApplicationContext ctx = (ApplicationContext) req.getServletContext()
                    .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

            SecurityManager sm = (SecurityManager) ctx.getBean("securityManager");
            SecurityUtils.setSecurityManager(sm);
            Subject currentUser = SecurityUtils.getSubject();
            Object obj = currentUser.getSession().getAttribute("Login_Customer");

            if (obj == null) {
                req.getRequestDispatcher("/toLogin").forward(request, rep);
            } else {
                CustomerModel cm = (CustomerModel) obj;
                if (cm == null || cm.getCustomerId() == null || cm.getCustomerId().trim().length() == 0) {
                    req.getRequestDispatcher("/toLogin").forward(request, rep);
                } else {
                    chain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
