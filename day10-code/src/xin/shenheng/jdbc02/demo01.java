package xin.shenheng.jdbc02;

import java.util.*;

public class demo01 {
    public static void main(String[] args) {
        domo();




    }

    private static void domo02() {


        RunnableTmpl run = new RunnableTmpl();
        Thread thread = new Thread(run);
        thread.start();
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName());
        }


    }

    private static void domo() {

        HashMap<Integer,String> poker = new HashMap<>();

        ArrayList<Integer> pokerIndex = new ArrayList<>();

        List<String> colors = List.of("♠", "♥", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;

        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历两个集合,组装52张牌,存储到集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }
        // System.out.println(poker);

        Collections.shuffle(pokerIndex);

        //System.out.println(pokerIndex);

        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            if (i>=51){
                diPai.add(in);
            }else if(i % 3 == 0) {
                player01.add(in);
            }else if(i % 3 == 1) {
                player02.add(in);
            }else if(i % 3 == 2) {
                player03.add(in);
            }

        }
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(diPai);
        lookPoker("黄晓明",poker,player01);
        lookPoker("黄药师",poker,player02);
        lookPoker("欧阳峰",poker,player03);
        lookPoker("底牌",poker,diPai);
    }

    /*
        定义一个看牌的方法,提高代码的复用性
        参数:
            String name:玩家名称
            HashMap<Integer,String> poker:存储牌的poker集合
            ArrayList<Integer> list:存储玩家和底牌的List集合
        查表法:
             遍历玩家或者底牌集合,获取牌的索引
             使用牌的索引,去Map集合中,找到对应的牌
     */
    public static void lookPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list){
        //输出玩家名称,不换行
        System.out.print(name+":");
        //遍历玩家或者底牌集合,获取牌的索引
        for (Integer key : list) {
            //使用牌的索引,去Map集合中,找到对应的牌
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        System.out.println();//打印完每一个玩家的牌,换行
    }
}
