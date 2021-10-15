package com.ofben.autordemo.spring.validation.databinding;

/**
 * bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class DependsOnExoticType {

    private ExoticType type;

    public void setType(ExoticType type) {
        this.type = type;
    }

    public ExoticType getType() {
        return type;
    }
}
