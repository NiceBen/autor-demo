package com.ofben.autordemo.callback.demo1;

public class Manager implements CallbackInterface {

    private Programmer programmer;

    public Manager(Programmer programmer) {
        this.programmer = programmer;
    }

    /**
     * 用于 Boss 下达的委托
     */
    public void entrust() {
        arrange();
    }

    /**
     * 进行安排下属进行 study 工作
     */
    private void arrange() {
        System.out.println("Manager 正在为 Programmer 安排工作");
        programmer.study(Manager.this);
        System.out.println("为 Programmer 安排工作已经完成，Manager 做其他的事情去了");
    }

    @Override
    public boolean check(int result) {
        if (result == 5) {
            return true;
        }
        return false;
    }
}
