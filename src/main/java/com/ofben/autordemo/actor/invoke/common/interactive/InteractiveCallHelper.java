package com.ofben.autordemo.actor.invoke.common.interactive;

import com.alibaba.fastjson.JSON;
import com.ofben.autordemo.actor.invoke.common.interactive.modulemgr.utils.InteractiveUtil;
import com.ofben.autordemo.actor.invoke.common.interactive.modulemgr.vo.ModuleModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * 辅助远程调用类：模块间相互调用的辅助类
 *
 * @author SL Zhou
 * @date 2021-08-16
 * @since 1.0.0
 */
@Service
public class InteractiveCallHelper {

    /**
     * 实现模块间的远程调用
     * @param moduleId      模块ID
     * @param opeType       调用具体业务操作类型
     * @param mapParams     调用所需要传递的参数
     * @return              服务端返回的 Json 数据
     */
    public String call(String moduleId, String opeType, Map<String, Object> mapParams) {
        // 1.根据 moduleId 获取该模块的部署的信息
        // Mock 模块管理
        ModuleModel mm = new ModuleModel();
//        mm.setDeployIP("localhost");
//        mm.setDeployPort("9080");
//        mm.setInteractiveUrl("/goods/goodsFI/call");

        // 临时操作
        mm.setDeployIP(mapParams.get("ip").toString());
        mm.setDeployPort(mapParams.get("port").toString());
        mm.setInteractiveUrl(mapParams.get("url").toString());
        mapParams.remove("ip");
        mapParams.remove("port");
        mapParams.remove("url");

        // 2.准备要传递的数据，把Map转换成JSON
        String paramStr = JSON.toJSONString(mapParams);
        paramStr = paramStr.replace("#", "*");

        // 3.拼接一个远程调用的 URL
        String urlStr = "http://" + mm.getDeployIP() + ":" + mm.getDeployPort() + mm.getInteractiveUrl()
                + "?jsonParam={opeType:" + opeType + ", map:" + paramStr + "}";

        // 4.使用 URL 进行远程调用，流式操作
        InputStream in = null;
        String retJson = "";
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            in = conn.getInputStream();
            // 5.得到返回值，关闭
            byte[] bs = new byte[in.available()];
            in.read(bs);
            // 返回
            retJson = new String(bs);
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retJson;
    }

    /**
     * 实现模块间的远程调用
     * @param moduleId      模块ID
     * @param opeType       调用具体业务操作类型
     * @param mapParams     调用所需要传递的参数
     * @param cls           要转成的业务对象的 class
     * @return              业务对象模型
     */
    public <T> T call(String moduleId, String opeType, Map<String, Object> mapParams, Class<T> cls) {
        String json = this.call(moduleId, opeType, mapParams);
        T ret = InteractiveUtil.retJson2Model(json, cls);
        return ret;
    }
}
