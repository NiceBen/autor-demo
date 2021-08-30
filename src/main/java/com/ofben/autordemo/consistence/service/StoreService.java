package com.ofben.autordemo.consistence.service;

import com.ofben.autordemo.model.dto.StoreModel;

/**
 * TODO
 *
 * @date 2021-08-17
 * @since 1.0.0
 */
public interface StoreService {

    StoreModel getByGoodsUuid(int goodsUuid);

    void updateByGoodsUuid(int goodsUuid, int adjustNum);
}
