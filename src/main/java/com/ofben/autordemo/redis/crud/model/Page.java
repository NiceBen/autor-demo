package com.ofben.autordemo.redis.crud.model;

import lombok.Data;

/**
 * 分页对象
 *
 * @author SL Zhou
 * @date 2021-08-26
 * @since 1.0.0
 */
@Data
public class Page{
    private Integer nowPage;

    private Integer pageShow;

    private Integer totalCount;
}
