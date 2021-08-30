package com.ofben.autordemo.redis.crud.model;

import lombok.Data;

/**
 * 实体类
 *
 * @date 2021-08-26
 * @since 1.0.0
 */
@Data
public class GoodsModel {

    private int uuid;

    private String name;

    private String imgPath;

    private String description;
}
