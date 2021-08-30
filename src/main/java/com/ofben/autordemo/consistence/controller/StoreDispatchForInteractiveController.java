package com.ofben.autordemo.consistence.controller;

import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveBaseController;
import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveCallHelper;
import com.ofben.autordemo.model.dto.StoreModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 分配的 Controller
 *
 * @date 2021-08-17
 * @since 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/storeDispatchFI")
public class StoreDispatchForInteractiveController extends InteractiveBaseController {

    @Autowired
    private InteractiveCallHelper call = null;

    @Override
    protected Object doCall(String opeType, Map<String, Object> map) {
        // 1.分别掉用bj和sh的库存管理模块，去获得当前他们各自的A商品的库存数据
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("goodsUuid", "2");

        // 北京
        mapParam.put("ip", "localhost");
        mapParam.put("port", "9080");
        mapParam.put("url", "/storeFI/call");
        StoreModel bjsm = call.call("goodsModule", "1", mapParam, StoreModel.class);

        // 上海
        mapParam.put("ip", "localhost");
        mapParam.put("port", "8080");
        mapParam.put("url", "/front/storeFI/call");
        StoreModel shsm = call.call("goodsModule", "1", mapParam, StoreModel.class);

        // 2.进行逻辑判断，是否需要调整他们的库存
        // 3.如果需要调整，按照一定的业务算法来计算新的数据
        int avg = (bjsm.getStoreNum() + shsm.getStoreNum()) >> 1;

        // 4.把这些新的数据分别调用回去
        // 北京
        mapParam.put("ip", "localhost");
        mapParam.put("port", "9080");
        mapParam.put("url", "/storeFI/call");
        mapParam.put("adjustNum", bjsm.getStoreNum() - avg);
        call.call("goodsModule", "2", mapParam, StoreModel.class);

        // 上海
        mapParam.put("ip", "localhost");
        mapParam.put("port", "8080");
        mapParam.put("url", "/front/storeFI/call");
        mapParam.put("adjustNum", shsm.getStoreNum() - avg);
        call.call("goodsModule", "2", mapParam, StoreModel.class);

        return "{}";
    }
}
