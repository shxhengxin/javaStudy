package xin.shenheng.demo03;

public interface MyInterFaceDefault {
    public abstract void methodAbs();
    public default void methodAbs2() {
        System.out.println("这是新添加的默认方法");
    }
}
