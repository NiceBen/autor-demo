package com.ofben.autordemo.test.reflect.remote.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * client
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class SimpleClient {

    private void invoke() throws Exception {
        Socket socket = new Socket("localhost", 8000);
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        // 创建一个远程调用对象
        Call call = new Call("com.ofben.autordemo.test.reflect.remote.server.service.HelloService",
                "echo", new Class[]{String.class}, new Object[]{"hello"});
        // 向服务器发送Call对象
        oos.writeObject(call);
        // 接收包含了方法执行结果的Call对象
        call = (Call) ois.readObject();
        System.out.println(call.getResult());
        ois.close();
        oos.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        new SimpleClient().invoke();
    }
}
