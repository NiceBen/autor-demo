package com.ofben.autordemo.test.reflect.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> strList = new ArrayList<>();
		strList.add(11);
		strList.add(22);

		//	strList.add(100);
		//获取ArrayList的Class对象，反向的调用add()方法，添加数据
		Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
		//获取add()方法
		Method m = listClass.getMethod("add", Object.class);
		//调用add()方法
		m.invoke(strList, "aaa");

		strList.add(33);

		//遍历集合
		for (Object obj : strList) {
			System.out.println(obj);
		}
	}
}