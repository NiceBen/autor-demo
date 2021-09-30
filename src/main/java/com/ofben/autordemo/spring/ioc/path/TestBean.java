package com.ofben.autordemo.spring.ioc.path;

/**
 * Bean
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class TestBean {

    private String target;

    public int age = 15;

    private TestBean spouse;

    private String country;

    public TestBean(String publicInstance) {
        this.target = publicInstance;
    }

    public TestBean(String publicInstance, int i) {
        this.target = publicInstance;
    }

    public void setSpouse(TestBean spouse) {
        this.spouse = spouse;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "target='" + target + '\'' +
                ", age=" + age +
                ", spouse=" + spouse +
                ", country='" + country + '\'' +
                '}';
    }
}
