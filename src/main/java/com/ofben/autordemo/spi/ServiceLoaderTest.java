package com.ofben.autordemo.spi;

import com.ofben.autordemo.spi.intf.IShout;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * {@link ServiceLoader} test
 *
 * @date 2021-09-22
 * @since 1.0.0
 */
public class ServiceLoaderTest {

    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        Iterator<IShout> iterator = shouts.iterator();
        while (iterator.hasNext()) {
            IShout shout = iterator.next();
            shout.shout();
        }
    }
}
