package com.ofben.autordemo.spring.bean;

/**
 * Bean
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class ThingOne {

    private ThingTwo thingTwo;

    private ThingThree thingThree;

    private String email;

    public ThingOne(ThingTwo thingTwo, ThingThree thingThree, String email) {
        this.thingTwo = thingTwo;
        this.thingThree = thingThree;
        this.email = email;
    }

    public void setThingTwo(ThingTwo thingTwo) {
        this.thingTwo = thingTwo;
    }

    public void setThingThree(ThingThree thingThree) {
        this.thingThree = thingThree;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ThingOne{" +
                "thingTwo=" + thingTwo +
                ", thingThree=" + thingThree +
                ", email='" + email + '\'' +
                '}';
    }
}
