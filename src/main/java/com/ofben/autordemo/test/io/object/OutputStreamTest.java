package com.ofben.autordemo.test.io.object;

import java.io.*;

public class OutputStreamTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String path = "e:/myJava/test.txt";

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));

            Person p1 = new Person("张三", 12, true);
            Person p2 = new Person("李四", 33, false);
            oos.writeObject(p1);
            oos.writeObject(p2);

            oos.writeObject(null);
            //如果不写入一个null对象 ，则读取的时候会报异常EOFException ,则需要try catch 捕获异常   （已经注释）
            oos.flush();
            System.out.println("写入完毕");


            ois = new ObjectInputStream(new FileInputStream(path));
            Object object = ois.readObject();
            while( object !=null){
                System.out.println(object.toString());
                object = ois.readObject();
            }

        }
//      catch(EOFException e){
//          System.out.println("end");
//      }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(oos!= null){
            try {
                oos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
            if(ois!= null){
                try {
                    ois.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }

}

class Person implements Serializable{
    private String name ;
    private int age;
    private boolean sex;

    private void Perosn() {
        // TODO Auto-generated method stub

    }

    public Person(String name, int age, boolean sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + (sex?"男":"女") + "]";
    }

}