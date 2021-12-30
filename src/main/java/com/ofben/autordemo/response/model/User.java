package com.ofben.autordemo.response.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * TODO
 *
 * @date 2021-12-29
 * @since TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private Integer age;

    private String gender;
}
