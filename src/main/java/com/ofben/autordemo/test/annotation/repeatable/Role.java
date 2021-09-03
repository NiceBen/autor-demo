package com.ofben.autordemo.test.annotation.repeatable;

import java.lang.annotation.Repeatable;

/**
 * TODO
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
@Repeatable(value = Roles.class)
public @interface Role {

    String roleName();
}
