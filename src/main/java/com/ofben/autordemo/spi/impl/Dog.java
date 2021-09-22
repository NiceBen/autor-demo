package com.ofben.autordemo.spi.impl;

import com.ofben.autordemo.spi.intf.IShout;

/**
 * {@link IShout} implement
 *
 * @date 2021-09-22
 * @since 1.0.0
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang !");
    }
}
