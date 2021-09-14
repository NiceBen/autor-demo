package com.ofben.autordemo.test.reflect.remote.server;

import com.ofben.autordemo.test.reflect.remote.client.Call;
import com.ofben.autordemo.test.reflect.remote.server.service.HelloServiceImpl;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Server
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class SimpleServer {
    // 存放远程对象的缓存
    private Map<String, Object> remoteObjects = new HashMap<>();

    /**
     * 把一个远程对象放到缓存中
     */
    private void register(String className, Object remoteObject) {
        remoteObjects.put(className, remoteObject);
    }

    public void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("服务器启动.");
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // 接收客户发送的Call对象
            Call call = (Call) ois.readObject();
            System.out.println(call);
            // 调用相关对象的方法
            call = invoke(call);
            // 向客户发送包含了执行结果的Call对象
            oos.writeObject(call);
            ois.close();
            oos.close();
            socket.close();
        }
    }

    private Call invoke(Call call) {
        Object result = null;
        try {
            String className = call.getClassName();
            String methodName = call.getMethodName();
            Class[] paramTypes = call.getParamTypes();
            Object[] params = call.getParams();

            Class classType = Class.forName(className);
            Method method = classType.getMethod(methodName, paramTypes);
            // 从缓存中取出相关的远程对象
            Object remoteObject = remoteObjects.get(className);
            if (remoteObject == null) {
                throw new Exception(className + "的远程对象不存在");
            } else {
                result = method.invoke(remoteObject, params);
            }
        } catch (Exception e) {
            result = e;
        }
        // 设置方法执行结果
        call.setResult(result);
        return call;
    }

    public static void main(String[] args) throws Exception {
        String className = "com.ofben.autordemo.test.reflect.remote.server.service.HelloService";
        SimpleServer server = new SimpleServer();
        // 把事先创建的HelloServiceImpl对象加入到服务器的缓存中
        server.register(className, new HelloServiceImpl());
        server.service();
    }
}
