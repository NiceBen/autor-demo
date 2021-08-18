package com.ofben.autordemo.varnish.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * {@link PurgeMethod} 工具类
 *
 * @author SL Zhou
 * @date 2021-08-18
 * @since 1.0.0
 */
public class PurgeVarnishUtil {

    public static void purge(String url) {
        HttpClient client = new HttpClient();
        HttpMethod method = new PostMethod(url);

        try {
            int status = 0;
            status = client.executeMethod(method);
            System.out.println("status===" + status);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }

    public static void main(String[] args) {
        // 这里访问的 varnish 的端口
        PurgeVarnishUtil.purge("http://localhost:1111/a.jsp");
    }
}

class PurgeMethod extends HttpMethodBase {

    public PurgeMethod() {
        super();
        setFollowRedirects(true);
    }

    public PurgeMethod(String uri)  {
        super(uri);
        setFollowRedirects(true);
    }

    @Override
    public String getName() {
        return "PURGE";
    }
}

