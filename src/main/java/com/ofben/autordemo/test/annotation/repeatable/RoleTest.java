package com.ofben.autordemo.test.annotation.repeatable;

/**
 * {@link Role}
 *
 * @date 2021-09-03
 * @see Role
 * @since 1.0.0
 */
public class RoleTest {

//    @Roles(value = {
//            @Role(roleName = "role1"),
//            @Role(roleName = "role2")
//    })
    @Role(roleName = "role1")
    @Role(roleName = "role2")
    public String doString() {
        return "hello world";
    }
}
