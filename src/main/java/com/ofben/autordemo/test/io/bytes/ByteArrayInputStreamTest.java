package com.ofben.autordemo.test.io.bytes;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * {@link ByteArrayInputStream}
 *
 * @date 2021-09-09
 * @since 1.0.0
 */
public class ByteArrayInputStreamTest {

    public static void main(String[] args) {
        byte[] buffer = new byte[]{80, 81, 82, 83, 84};
//        testReadNone(buffer);

        testReadOffLen(buffer);
    }

    private static void testReadOffLen(byte[] buffer) {
        System.out.println(buffer.length);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer, 0, 3)) {
            byte[] result = new byte[100];
            int index = 0;
            int count;
            while ((count = bais.read(result, index, 1)) != -1) {
                System.out.println(new String(result));
                index = index + count;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testReadNone(byte[] buffer) {
        try(ByteArrayInputStream bais = new ByteArrayInputStream(buffer)) {
            int read;
            while ((read = bais.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
