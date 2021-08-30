package com.ofben.autordemo.staticize;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * {@link Filter} 实现
 *
 * @date 2021-08-19
 * @since 1.0.0
 */
@Slf4j
public class GenStaticHtmlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //1.取到访问的 URL
        String urlPath = request.getRequestURI();
        String gen = request.getParameter("gen");

        //2.判断是否需要静态化
        if (urlPath.endsWith("/toIndex") && !"true".equals(gen)) {
            //3.对于需要静态化的，判断是否已经有了静态化的内容
            byte[] bs = GenHtml.mapHtml.get("toIndex");
            if (bs != null || bs.length > 0) {
                //3.1如果有：直接取出来，返回客户端
                log.info("now have static index，date{}", new Date());
            } else {
                //3.2如果没有：就调用后端 genStaticHtml() 生成 Html 的方法，然后获取内容返回
                new GenHtml().genStaticHtml();
                bs = GenHtml.mapHtml.get("toIndex");
            }
            // 4.直接返回
            response.getOutputStream().write(bs);
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
