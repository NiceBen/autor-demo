package com.ofben.autordemo.consistence.service.impl;

import com.ofben.autordemo.consistence.service.StoreService;
import com.ofben.autordemo.model.dto.StoreModel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * TODO
 *
 * @date 2021-08-17
 * @since TODO
 */
@Service
public class StoreServiceImpl implements StoreService {

    private StoreModel sm = null;

    @PostConstruct
    public void init() {
        sm = new StoreModel();
        sm.setGoodsUuid(2);
        sm.setStoreNum(100);
    }

    @Override
    public StoreModel getByGoodsUuid(int goodsUuid) {
        return sm;
    }

    @Override
    public void updateByGoodsUuid(int goodsUuid, int adjustNum) {
        if (goodsUuid == sm.getGoodsUuid()) {
            Integer storeNum = sm.getStoreNum();
            sm.setStoreNum(storeNum - adjustNum);
        }
    }
}
