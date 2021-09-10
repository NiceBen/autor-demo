package com.ofben.autordemo.test.io.bytes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * {@link ByteArrayOutputStream}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class ByteArrayOutputStreamTest {

    public static void main(String[] args) {
        byte[] source = new byte[]{80, 81, 82, 83, 84};
        try (ByteArrayOutputStream out = new ByteArrayOutputStream(10)) {
            out.write(source, 0, 5);
            System.out.println("size:" + out.size());
            byte[] target = out.toByteArray();
            System.out.println(Arrays.toString(target));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
