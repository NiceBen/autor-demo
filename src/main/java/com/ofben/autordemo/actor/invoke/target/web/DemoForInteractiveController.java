package com.ofben.autordemo.actor.invoke.target.web;

import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveBaseController;
import com.ofben.autordemo.actor.invoke.target.web.mock.model.vo.GoodsModel;
import com.ofben.autordemo.actor.invoke.target.web.mock.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 提供给外部远程调用的控制器
 *
 * @date 2021-08-16
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/goodsFI")
public class DemoForInteractiveController extends InteractiveBaseController {

    @Autowired
    private GoodsService gs;

    @Override
    protected Object doCall(String opeType, Map<String, Object> map) {
        // 根据 opeType 来转调逻辑层的业务方法
        if ("1".equals(opeType)) {
            // 调用某个方法：get
            System.out.println("now 处理 optType==" + opeType);
        } else if("2".equals(opeType)) {
            System.out.println("now 处理 optType2222==" + opeType);
        }
        // 准备一个测试数据来返回
        GoodsModel gm = new GoodsModel();
        gm.setName("goods123");
        gm.setUuid(11);

        return gm;
    }
}
