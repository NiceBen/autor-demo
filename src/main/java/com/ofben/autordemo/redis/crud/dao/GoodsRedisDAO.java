package com.ofben.autordemo.redis.crud.dao;

import com.ofben.autordemo.redis.crud.model.GoodsModel;
import com.ofben.autordemo.redis.crud.model.GoodsQueryModel;

import java.util.List;

/**
 * TODO
 *
 * @date 2021-08-26
 * @since 1.0.0
 */
public interface GoodsRedisDAO extends BaseDAO<GoodsModel, GoodsQueryModel> {

    List<Integer> getIdsByConditionPage(GoodsQueryModel gqm);

    List<GoodsModel> getByIds(String ids);
}
