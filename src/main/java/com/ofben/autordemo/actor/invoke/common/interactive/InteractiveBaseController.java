package com.ofben.autordemo.actor.invoke.common.interactive;

import com.ofben.autordemo.actor.invoke.common.interactive.modulemgr.utils.InteractiveUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 进行模块间交互调用的基础控制器
 *
 * @date 2021-08-16
 * @since 1.0.0
 */
public abstract class InteractiveBaseController {

    @RequestMapping("/call")
    @ResponseBody
    public Object call(@RequestParam("jsonParam") String jsonParam) {
        if (jsonParam != null && jsonParam.contains("*")) {
            jsonParam = jsonParam.replace("*", "#");
        }
        InteractiveModel im = InteractiveUtil.paramJson2Model(jsonParam);
        // 去做真正的业务处理
        Object ret = doCall(im.getOpeType(), im.getMap());
        return ret;
    }

    protected abstract Object doCall(String opeType, Map<String, Object> map);
}
