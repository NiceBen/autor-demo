package com.ofben.autordemo.actor.invoke.common.test;

import com.ofben.autordemo.actor.invoke.target.web.mock.model.vo.GoodsModel;
import lombok.Data;

/**
 * {@link GoodsModel} Test
 *
 * @author SL Zhou
 * @date 2021-08-16
 * @since 1.0.0
 */
@Data
public class MyRetModel {

    private int uuid;

    private String name;

    private String desc;
}
