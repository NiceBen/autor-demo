package com.ofben.autordemo.staticize;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * {@link ServletContextListener} 实现
 *
 * @date 2021-08-19
 * @since 1.0.0
 */
public class GenStaticHtmlListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ctx = (ApplicationContext) sce.getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        GenHtml genHtml = new GenHtml();
        genHtml.startGenStaticHtml();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
