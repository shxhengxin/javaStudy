package xin.shenheng.demo05;

public class String_Demo01 {
    /*public static void main(String[] args) {
        int[] arr = {2,4,52,2};
        int index = 3;
        int elemnt = getElemnt(arr, index);
        System.out.println(elemnt);

    }*/

    public static void main(String[] args) {
        MyThread myThread = new MyThread("新的线程！");
        myThread.start();
        String name = myThread.getName();
        System.out.println(name);

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程"+i);
        }
    }

    private static int getElemnt(int[] arr,int index) {
        if(index < 0 || index>arr.length-1) {
            throw new ArrayIndexOutOfBoundsException("哥们,角标越界了~~~~");
        }
        int element = arr[index];
        return  element;
    }

}
