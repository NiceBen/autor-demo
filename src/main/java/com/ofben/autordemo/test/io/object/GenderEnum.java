package com.ofben.autordemo.test.io.object;

/**
 * 性别
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public enum GenderEnum {

    MALE(1),FEMALE(2);

    GenderEnum(int gender) {
        this.gender = gender;
    }

    private int gender;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
