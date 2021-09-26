package com.ofben.autordemo.spring.bean;

import java.util.Collection;
import java.util.Map;

/**
 * {@link Collection}
 *
 * @date 2021-09-26
 * @see Collection
 * @since 1.0.0
 */
public class SomeClass {

    private Map<String, Float> accounts;

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Float> getAccounts() {
        return accounts;
    }
}
