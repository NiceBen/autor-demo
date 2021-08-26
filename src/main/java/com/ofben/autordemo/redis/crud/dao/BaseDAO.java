package com.ofben.autordemo.redis.crud.dao;

import java.util.List;

/**
 * 基础查询
 *
 * @author SL Zhou
 * @date 2021-08-26
 * @since 1.0.0
 */
public interface BaseDAO<M, QM> {

    void create(M m);

    void update(M m);

    void delete(int uuid);

    M getByUuid(int uuid);
    List<M> getByConditionPage(QM qm, int nowPage, int pageShow);
}
