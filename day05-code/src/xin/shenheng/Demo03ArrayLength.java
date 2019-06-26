package xin.shenheng;

public class Demo03ArrayLength {
    //public static void main(String[] args) {
        /*int[] array = {5,15,10000,30,20};
        int max = array[0];
        for(int i = 1;i< array.length;i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);*/

        
        /*int[] arrayA = {10,20,5,60};
        for (int min = 0,max = arrayA.length-1; min < max; min++,max--) {
            int temp = arrayA[min];
            arrayA[min] = arrayA[max];
            arrayA[max] = temp;
        }
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(arrayA[i]);
        }*/


        
    //}




        public static void main(String[] args) {
            //调用方法
            printFlower();
        }

        /*
         * 把所有的水仙花数打印在控制台
         *
         * 两个明确：
         * 		返回值类型：void
         * 		参数列表：
         */
        public static void printFlower() {
            for(int x=100; x<1000; x++) {
                int ge = x%10;
                int shi = x/10%10;
                int bai = x/10/10%10;

                if((ge*ge*ge+shi*shi*shi+bai*bai*bai) == x) {
                    System.out.println(x);
                }
            }
        }


}
