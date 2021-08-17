package com.ofben.autordemo.consistence.controller;

import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveBaseController;
import com.ofben.autordemo.consistence.service.StoreService;
import com.ofben.autordemo.model.dto.StoreModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 各个模块的管理控制器
 *
 * @author SL Zhou
 * @date 2021-08-17
 * @since 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/storeFI")
public class StoreForInteractiveController extends InteractiveBaseController {

    @Autowired
    private StoreService ss;

    @Override
    protected Object doCall(String opeType, Map<String, Object> map) {
        if ("1".equals(opeType)) {
            // 获取A商品的库存数据
            int goodsUuid = Integer.parseInt(map.get("goodsUuid").toString());
            StoreModel sm = ss.getByGoodsUuid(goodsUuid);
            log.info("StoreForInteractiveController#doCall:StoreModel:{}", sm);
            return sm;
        } else if ("2".equals(opeType)) {
            // 把新的库存数据进行调整，并更新到数据库
            int goodsUuid = Integer.parseInt(map.get("goodsUuid").toString());
            int adjustNum = Integer.parseInt(map.get("adjustNum").toString());
            ss.updateByGoodsUuid(goodsUuid, adjustNum);
        }

        return "{}";
    }
}
