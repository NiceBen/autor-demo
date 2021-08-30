package com.ofben.autordemo.redis.crud.model;

import lombok.Data;

/**
 * 查询对象
 *
 * @date 2021-08-26
 * @since 1.0.0
 */
@Data
public class GoodsQueryModel {

    private Integer uuid;

    private String name;

    private Page page;
}

