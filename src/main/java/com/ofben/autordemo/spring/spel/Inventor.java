package com.ofben.autordemo.spring.spel;

import java.util.Date;

/**
 * Bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class Inventor {

    private String name;

    private Date date;

    private String type;

    public Inventor(String name, Date date, String type) {
        this.name = name;
        this.date = date;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
