package com.ofben.autordemo.test.reflect.remote.client;

import java.io.Serializable;

/**
 * 描述远程调用的实体类
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class Call implements Serializable {
    private static final long serialVersionUID = -2563754685369940634L;

    // 表示类名或接口名
    private String className;
    // 表示方法名
    private String methodName;
    // 表示方法参数类型
    private Class[] paramTypes;
    // 表示方法参数值
    private Object[] params;

    // 表示方法的执行结果
    // 如果方法正常执行，则result为方法返回值，如果方法抛出异常，那么result为该异常。
    private Object result;

    public Call() {
    }

    public Call(String className, String methodName, Class[] paramTypes, Object[] params) {
        this.className = className;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Call{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '}';
    }
}
