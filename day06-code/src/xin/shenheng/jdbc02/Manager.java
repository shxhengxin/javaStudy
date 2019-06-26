package xin.shenheng.jdbc02;

import java.util.ArrayList;

public class Manager extends User {

    public Manager() {

    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        ArrayList<Integer> redList = new ArrayList<>();

        //自己有多少钱
        int leftMoney = super.getMoney();

        if(totalMoney > leftMoney) {
            System.out.println("余额不足");
            return  redList;//返回空集合
        }
        //扣钱
        super.setMoney(leftMoney - totalMoney);

        //发红包

        int avg = totalMoney / count;
        int mod = totalMoney % count;//余数
        //余数放在最后一个红包中

        //把红包放在集合中
        for (int i = 0; i < count-1; i++) {

            redList.add(avg);
        }
        //最后一个红包
        int last = avg + mod;
        redList.add(last);
        return  redList;


    }
}
