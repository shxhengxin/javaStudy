package xin.shenheng.demo09;

import java.util.ArrayList;

public interface OpenMode {
    /**
     * 请将totalMoney 分成 totalCount 保存到ArrayList<Integer>中返回
     * @param totalMoney 总金额为方便计算,已经转换为整数，单位为分
     * @param totalCount 红包个数
     * @return ArrayList<Integer> 元素为各个红包的金额值，所有元素的值累计和等于总金额
     */
    ArrayList<Integer> divide(int totalMoney,int totalCount);
}
